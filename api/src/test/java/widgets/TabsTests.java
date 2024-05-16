package widgets;

import org.junit.jupiter.api.Test;
import services.CommonRestRequests;

import static data.enums.ApiPaths.TABS;
import static data.enums.SchemasPaths.TAB;
import static restwrapper.conditions.Conditions.responseSchema;

class TabsTests {
    private final CommonRestRequests commonRestRequests = new CommonRestRequests();

    @Test
    void shouldGetTabsList() {
        commonRestRequests.getRequest(TABS.getPath())
                .shouldHave(responseSchema(getClass().getClassLoader()
                        .getResourceAsStream(TAB.getSchema())));
    }

}