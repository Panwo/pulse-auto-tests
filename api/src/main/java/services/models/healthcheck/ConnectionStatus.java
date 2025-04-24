package services.models.healthcheck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConnectionStatus {

    private ServerConnection configServer;
    private StatServer statServer0;
    private StatServer statServer1;
    private String dbServerConnection;
    private DbConnection dbConnection2;

}