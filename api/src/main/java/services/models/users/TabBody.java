package services.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TabBody {

    private String guid;
    private String title;
    private List<Position> position;
    private String type;
    private String source_guid;
    private String user_guid;
    private Integer cols;
    private Boolean active;

}