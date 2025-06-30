package services.models.layouts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Definition {

    private String layout_type;
    private int refresh_interval;
    private boolean enable_delta_snapshots;
    private List<Column> column;
    private CollectorDef collector_def;
    private String guid;
    private String template_guid;

}