package api.xm_api_tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest_api.BaseRestAssuredConfig;
import rest_api.pojo.xm.CharacterPojo;
import rest_api.pojo.xm.FilmPojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StarWarsAPITest extends BaseXMTest {

    @Test(testName = "Star wars test")
    public void test() {

        List<FilmPojo> filmPojos = getAllFilms();
        FilmPojo latestReleasedFilmPojo = getLatestReleasedFilm(filmPojos);
        Assert.assertNotNull(latestReleasedFilmPojo, "Verify if there is at least one film released");
        System.out.println("The latest released film is '" + latestReleasedFilmPojo.getTitle() + "' released on "
                + latestReleasedFilmPojo.getReleaseDate());

        List<CharacterPojo> lastFilmCharacters = getAllCharactersFromFilm(latestReleasedFilmPojo);
        CharacterPojo tallestCharacterInFilm = getTheTallestCharacter(lastFilmCharacters);
        Assert.assertNotNull(tallestCharacterInFilm, "Verify if there is at least one character in the film");
        System.out.println("The tallest character in the film '" + latestReleasedFilmPojo.getTitle() +
                "' is '" + tallestCharacterInFilm.getName() + "'. He is " + tallestCharacterInFilm.getHeight() + " cm.");

        List<CharacterPojo> allCharacters = getAllCharacters();
        CharacterPojo tallestCharacterInSaga = getTheTallestCharacter(allCharacters);
        Assert.assertNotNull(tallestCharacterInSaga, "Verify if there is at least one character in the saga");
        System.out.println("The tallest character in the saga is '" + tallestCharacterInSaga.getName() +
                "'. He is " + tallestCharacterInSaga.getHeight() + " cm.");

    }

    private List<CharacterPojo> getAllCharactersFromFilm(FilmPojo filmPojo) {
        List<CharacterPojo> characters = new ArrayList<>();
        for(String url : filmPojo.getCharacters()) {
            Response characterResponse = BaseRestAssuredConfig.sendGetRequest(url);

            characters.add(BaseRestAssuredConfig.getObjectFromApi(characterResponse, CharacterPojo.class));
        }
        return characters;
    }

    private CharacterPojo getTheTallestCharacter(List<CharacterPojo> characters) {
        return characters.stream()
                .max(Comparator.comparing(CharacterPojo::getHeight))
                .orElse(null);
    }

    private List<CharacterPojo> getAllCharacters() {
        Response allCharactersResponse = BaseRestAssuredConfig.sendGetRequest(PEOPLE_END_POINT);

        List<CharacterPojo> allCharacters = new ArrayList<>(BaseRestAssuredConfig.getObjectListFromApi(allCharactersResponse, CharacterPojo.class, "results"));

        String nextPageUrl = allCharactersResponse.getBody().jsonPath().get("next");
        while(nextPageUrl != null) {
            Response nextPageResponse = BaseRestAssuredConfig.sendGetRequest(nextPageUrl);
            allCharacters.addAll(BaseRestAssuredConfig.getObjectListFromApi(nextPageResponse, CharacterPojo.class, "results"));
            nextPageUrl = nextPageResponse.getBody().jsonPath().get("next");
        }
        Assert.assertFalse(allCharacters.isEmpty(), "Verify if there is at least one character");

        return allCharacters;
    }

    private List<FilmPojo> getAllFilms() {
        Response response = BaseRestAssuredConfig.sendGetRequest(FILMS_END_POINT);

        return BaseRestAssuredConfig.getObjectListFromApi(response, FilmPojo.class, "results");
    }

    private FilmPojo getLatestReleasedFilm(List<FilmPojo> filmPojos) {
        return filmPojos.stream()
                .max(Comparator.comparing(FilmPojo::getReleaseDate))
                .orElse(null);
    }

}
