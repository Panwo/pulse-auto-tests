package widgets;

import jdk.jfr.Label;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.CommonRestRequests;

import static data.enums.jsonschemas.Schemas.WIDGET_RESPONSE_SCHEMA;
import static data.enums.endpoints.WidgetsApi.*;
import static restwrapper.conditions.Conditions.contentType;
import static restwrapper.conditions.Conditions.responseSchema;

class WidgetsTests {

    private final CommonRestRequests requests = new CommonRestRequests();

    @Test
    @Tag("smoke")
    @Label("some dbid`s are missing")
    void shouldGetUsersList() {
        requests.getRequestOk(WIDGETS.getPath())
                .shouldHave(contentType("application/json"))
                .shouldHave(responseSchema(WIDGET_RESPONSE_SCHEMA.getPath()));
    }

}