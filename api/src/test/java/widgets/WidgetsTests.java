package widgets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.widgets.WidgetsRequests;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_OK;
import static data.enums.jsonschemas.Schemas.WIDGET_RESPONSE_SCHEMA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static restwrapper.conditions.Conditions.responseSchema;
import static restwrapper.conditions.Conditions.statusCode;

@Tag("apiWidgets")
@Tag("apiRegression")
class WidgetsTests {

    private final WidgetsRequests widgetsRequests = new WidgetsRequests();
    private final String WIDGET_GUID = "005056931883-810c-11e6-865c-75e4c9c3";

    @Test
    @Tag("apiSmoke")
    void shouldGetWidgets() {
        widgetsRequests.getWidgetsResponse()
                .shouldHave(statusCode(SC_OK))
                .shouldHave(responseSchema(WIDGET_RESPONSE_SCHEMA.getPath()));
    }

    @Test
    @Tag("apiSmoke")
    void shouldGetWidgetById() {
        var widget = widgetsRequests.getWidget(WIDGET_GUID);
        assertThat(widget.getBody().getGuid(), equalTo(WIDGET_GUID));
    }

}