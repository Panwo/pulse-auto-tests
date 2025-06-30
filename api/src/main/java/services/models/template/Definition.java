package services.models.template;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Definition {

    @JsonProperty("refresh_interval")
    private int refreshInterval;
    @JsonProperty("proxy_access_object")
    private ProxyAccessObject proxyAccessObject;
    @JsonProperty("collector_label")
    private ArrayList<String> collectorLabel;
    @JsonProperty("layout_type")
    private String layoutType;
    @JsonProperty("enable_delta_snapshots")
    private boolean enableDeltaSnapshots;
    @JsonProperty("default_widget_body")
    private DefaultWidgetBody defaultWidgetBody;
    @JsonProperty("collector_def")
    private CollectorDef collectorDef;

    private String name;
    private String description;
    private ArrayList<Column> column;
    private String guid;


}