package services.models.widgets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Body {

    private String guid;
    private String label;
    private int size_x;
    private int size_y;
    private List<View> view;
    private String active_view;
    private int refresh_interval;
    private List<ColumnVisibility> column_visibility;
    private String layout_guid;
    private long layout_body_hash;
    private String user_guid;
    private LayoutHashId layout_hash_id;
    private boolean hide_title;
    private boolean enable_agent_management;

}