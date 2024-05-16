package data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SchemasPaths {

    WIDGET("widgetSchema.json"),
    USER("usersSchema.json"),
    LAYOUT("layoutSchema.json"),
    TAB("tabsSchema.json");

    private final String schema;

}