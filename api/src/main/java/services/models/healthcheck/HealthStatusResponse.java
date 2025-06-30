package services.models.healthcheck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class HealthStatusResponse {

    private StatusWrapper configServer;
    private StatusWrapper database;
    private Map<String, Collector> collectors;
    private long timestamp;

}