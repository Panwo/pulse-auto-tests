package data.enums.jsonschemas;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Schemas {

    WIDGET_RESPONSE_SCHEMA("widgetSchema.json"),
    TEMPLATE_RESPONSE_SCHEMA("templateSchema.json"),
    USER_RESPONSE_SCHEMA("usersSchema.json"),
    LAYOUT_RESPONSE_SCHEMA("layoutSchema.json"),
    TAB_RESPONSE_SCHEMA("tabsSchema.json"),
    HEALTH_RESPONSE_SCHEMA("healthSchema.json");

    private final String path;

}