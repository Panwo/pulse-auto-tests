package widgets;

import data.enums.SchemasPaths;
import org.junit.jupiter.api.Test;
import services.CommonRestRequests;

import static data.enums.ApiPaths.WIDGETS;
import static data.enums.SchemasPaths.*;
import static restwrapper.conditions.Conditions.responseSchema;

class WidgetsTests {

    private final CommonRestRequests requests = new CommonRestRequests();

    @Test
    void shouldGetWidgetList() {
        requests.getRequest(WIDGETS.getPath())
                .shouldHave(responseSchema(getClass ().getClassLoader ()
                        .getResourceAsStream (WIDGET.getSchema())));
    }

}