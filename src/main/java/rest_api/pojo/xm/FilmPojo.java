package rest_api.pojo.xm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import rest_api.pojo.BasePojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmPojo extends BasePojo {

    public String title;

    @JsonProperty("episode_id")
    public int episodeID;

    @JsonProperty("opening_crawl")
    public String openingCrawl;

    public String director;

    public String producer;

    @JsonProperty("release_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate releaseDate;

    public ArrayList<String> characters;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'H:mm:ss.SSSSSS'Z'")
    public LocalDateTime created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'H:mm:ss.SSSSSS'Z'")
    public LocalDateTime edited;

    public String url;
}
