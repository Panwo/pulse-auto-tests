package services.models.snapshots;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class SnapshotsResponse {

    public long timestamp;
    public String type;
    public String layout_type;
    public State state;
    public List<ColItem> col;
    public GeneratorInfo generator_info;
    public int refresh_interval;
    public List<Prop> prop;
    public String layout_guid;
    public int max_statistic_value_delay;
    public long max_statistic_value_delay_timestamp;

}