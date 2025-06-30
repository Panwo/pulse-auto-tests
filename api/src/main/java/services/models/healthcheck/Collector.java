package services.models.healthcheck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Collector {

    private String currentTimestamp;
    private String startupTimestamp;
    private String uptime;
    private ConnectionStatus connectionStatus;
    private boolean snapshotWritingStatus;
    private String pendingLayoutStatusChangesCount;
    private int maxStatisticValueDelay;
    private String activeLayoutCount;
    private String deactivatedDanglingLayoutCount;
    private String version;

}