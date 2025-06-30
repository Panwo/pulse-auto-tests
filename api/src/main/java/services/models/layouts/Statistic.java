package services.models.layouts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Statistic {

    private String stat_type_name;
    private String notification_mode;
    private int notification_interval;
    private String filter;
    private String time_profile;
    private String time_range;

}