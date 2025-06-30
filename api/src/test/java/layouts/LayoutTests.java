package layouts;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.layouts.LayoutsRequests;

import static data.enums.jsonschemas.Schemas.LAYOUT_RESPONSE_SCHEMA;
import static data.enums.jsonschemas.Schemas.SNAPSHOT_SCHEMA;
import static org.apache.http.HttpStatus.SC_OK;
import static restwrapper.conditions.Conditions.responseSchema;
import static restwrapper.conditions.Conditions.statusCode;

@Tag("apiLayouts")
@Tag("apiRegression")
class LayoutTests {

    private final LayoutsRequests layoutsRequests = new LayoutsRequests();
    private final String AGENT_KPI_LAYOUT_ID = "005056931883-855c-11e6-6f06-7887c7c6";

    @Test
    @Tag("smokeApi")
    void shouldBeAbleToGetLayouts() {
        layoutsRequests.getLayoutsResponse()
                .shouldHave(statusCode(SC_OK))
                .shouldHave(responseSchema(LAYOUT_RESPONSE_SCHEMA.getPath()));
    }

    @Test
    @Tag("smokeApi")
    void shouldBeAbleToGetLayoutById() {
        layoutsRequests.getLayoutByIdResponse(AGENT_KPI_LAYOUT_ID)
                .shouldHave(statusCode(SC_OK));
    }

}