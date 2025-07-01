package services.models.healthcheck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class ConnectionStatus {

    private ServerConnection configServer;
    private StatServer statServer0;
    private StatServer statServer1;
    private String dbServerConnection;
    private DbConnection dbConnection2;

}