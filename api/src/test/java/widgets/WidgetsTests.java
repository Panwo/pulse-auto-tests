package widgets;

import jdk.jfr.Label;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.widgets.WidgetsRequests;

import static data.enums.jsonschemas.Schemas.WIDGET_RESPONSE_SCHEMA;
import static restwrapper.conditions.Conditions.contentType;
import static restwrapper.conditions.Conditions.responseSchema;

@Tag("apiWidgets")
class WidgetsTests {

    private final WidgetsRequests widgetsRequests = new WidgetsRequests();

    @Test
    @Tag("smoke")
    @Label("some dbid`s are missing")
    void shouldGetUsersList() {
        widgetsRequests.getWidgetsResponse()
                .shouldHave(contentType("application/json"))
                .shouldHave(responseSchema(WIDGET_RESPONSE_SCHEMA.getPath()));
    }

}