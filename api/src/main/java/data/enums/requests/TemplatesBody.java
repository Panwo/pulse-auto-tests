package data.enums.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemplatesBody {

    TEMPLATE("src/test/resources/requests/template.json"),
    INVALID_TEMPLATE_FORMAT_BODY("src/test/resources/requests/invalidTemplateFormat.raw.json"),
    INVALID_LAYOUT_DEFINITION_TEMPLATE_BODY("src/test/resources/requests/invalidLayoutDefinition.json");

    private final String body;

}