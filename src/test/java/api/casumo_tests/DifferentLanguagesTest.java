package api.casumo_tests;

import api.BaseApiTest;
import api.RetryAnalyzer;
import helpers.StringHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DifferentLanguagesTest extends BaseApiTest {

    private final String cyrillicConsonantsAndLatinVowels = StringHelper.generateRandomWord(
            StringHelper.allLowerCaseCyrillicConsonants, StringHelper.allLowerCaseLatinVowels);
    private final String latinConsonantsAndCyrillicVowels = StringHelper.generateRandomWord(
            StringHelper.allLowerCaseCyrillicVowels, StringHelper.allLowerCaseLatinConsonants);

    private final String lowerConsonantCyrillicWord = StringHelper.getRandomSymbolFrom(
            StringHelper.allLowerCaseCyrillicVowels) + StringHelper.generateRandomWord(StringHelper.lowerLatinAlphabet);
    private final String lowerVowelCyrillicWord = StringHelper.getRandomSymbolFrom(
            StringHelper.allLowerCaseCyrillicVowels) + StringHelper.generateRandomWord(StringHelper.lowerLatinAlphabet);

    private final String diacriticsWord = StringHelper.generateRandomWord(
            StringHelper.allDiacriticsVowels,StringHelper.allDiacriticsConsonants);



    @DataProvider(name = "dataProvider")
    public String[] wordDataProvider() {
        return new String[] {
                cyrillicConsonantsAndLatinVowels,
                latinConsonantsAndCyrillicVowels,
                lowerConsonantCyrillicWord,
                lowerVowelCyrillicWord,
                diacriticsWord
        };
    }
    @Test(testName = "Other Languages tests", description = "Test other languages values, which should return no errors",
            dataProvider = "dataProvider", retryAnalyzer = RetryAnalyzer.class)
    public void mainTest(String inputString) {
        sendStringAndVerifyVowelTrimmed(inputString);
    }
}
