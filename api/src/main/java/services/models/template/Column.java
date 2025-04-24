package services.models.template;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Column {

    private String id;
    private String category;
    private String type;
    private String vt;
    private boolean is_delta_key;
    private Formula formula;
    private String format;
    private String label;
    private String description;
    private Statistic statistic;

}