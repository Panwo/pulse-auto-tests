package services.models.healthcheck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatServer {

    private boolean present;
    private boolean connected;
    private String connectionTimestamp;
    private String disconnectTimestamp;
    private String totalStatisticCount;
    private String openedStatisticCount;
    private String failedStatisticCount;
    private String dataEventCount;

}