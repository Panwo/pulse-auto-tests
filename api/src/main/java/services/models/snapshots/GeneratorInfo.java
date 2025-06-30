package services.models.snapshots;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class GeneratorInfo {

    public String name;
    public String version;
    public long timestamp;
    public int cme_app_dbid;
    public String cme_app_name;
    public int pulse_app_id;

}