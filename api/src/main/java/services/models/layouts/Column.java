package services.models.layouts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Column {

    private String id;
    private String label;
    private String category;
    private String type;
    private String vt;
    private String format;
    private String description;
    private boolean is_delta_key;
    private SelectedValue selected_value;
    private HashId hash_id;
    private Formula formula;
    private Statistic statistic;

}