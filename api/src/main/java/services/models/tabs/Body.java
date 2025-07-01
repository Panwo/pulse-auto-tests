package services.models.tabs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Body {

    private String guid;
    private String title;
    private List<Object> widget;
    private String type;
    private String source_guid;
    private String user_guid;
    private int cols;
    private boolean active;

}