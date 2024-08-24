package rest_api.pojo.xm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import rest_api.pojo.BasePojo;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterPojo extends BasePojo {

    private String name;
    private Integer height;

    public void setHeight(String height) {
        try {
            this.height = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            this.height = -1;
        }
    }
}
