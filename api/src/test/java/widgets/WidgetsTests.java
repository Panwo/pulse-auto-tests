package widgets;

import jdk.jfr.Label;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static data.enums.endpoints.WidgetsApi.WIDGETS;
import static data.enums.jsonschemas.Schemas.WIDGET_RESPONSE_SCHEMA;
import static restwrapper.conditions.Conditions.contentType;
import static restwrapper.conditions.Conditions.responseSchema;
import static services.RestClient.getRequestOk;

class WidgetsTests {

    @Test
    @Tag("smoke")
    @Label("some dbid`s are missing")
    void shouldGetUsersList() {
        getRequestOk(WIDGETS.getPath())
                .shouldHave(contentType("application/json"))
                .shouldHave(responseSchema(WIDGET_RESPONSE_SCHEMA.getPath()));
    }

}