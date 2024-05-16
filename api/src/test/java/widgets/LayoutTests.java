package widgets;

import data.enums.SchemasPaths;
import org.junit.jupiter.api.Test;
import services.CommonRestRequests;

import static data.enums.ApiPaths.LAYOUTS;
import static restwrapper.conditions.Conditions.responseSchema;

class LayoutTests {
    private final CommonRestRequests requests = new CommonRestRequests();

    @Test
    void shouldGetLayoutsList() {
        requests.getRequest(LAYOUTS.getPath())
                .shouldHave(responseSchema(getClass ().getClassLoader ()
                        .getResourceAsStream (SchemasPaths.LAYOUT.getSchema())));
    }

}