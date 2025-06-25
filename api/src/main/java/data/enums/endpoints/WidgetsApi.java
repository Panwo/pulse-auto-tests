package data.enums.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WidgetsApi {

    WIDGETS("/wbrt/widgets"),
    WIDGET_GUID("/wbrt/widgets/%s"),
    WIDGET_GUID_BRIEF_DISABLED("/wbrt/widgets/%s/brief=false"),
    WIDGET_USCN("/wbrt/widgets?uscn=%s");

    private final String endpoint;

}