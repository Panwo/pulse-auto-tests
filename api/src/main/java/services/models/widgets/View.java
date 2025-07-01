package services.models.widgets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class View {

    private String type;
    private String subtype;
    private List<String> column_selector;
    private List<RowSelector> row_selector;
    private List<Prop> prop;
    private List<TableColumnWidth> table_column_width;

}