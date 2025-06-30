package snapshots;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.layouts.LayoutsRequests;

import static data.enums.jsonschemas.Schemas.SNAPSHOT_SCHEMA;
import static org.apache.http.HttpStatus.SC_OK;
import static restwrapper.conditions.Conditions.responseSchema;
import static restwrapper.conditions.Conditions.statusCode;

@Tag("apiSnapshots")
@Tag("apiRegression")
class SnapshotTests {

    private static final String AGENT_KPI_LAYOUT_ID = "005056931883-855c-11e6-6f06-7887c7c6";
    private final LayoutsRequests layoutsRequests = new LayoutsRequests();

    @Test
    @Tag("smokeApi")
    void shouldBeAbleToGetSnapshotForLayout() {
        layoutsRequests.getLayoutSnapshotResponse(AGENT_KPI_LAYOUT_ID)
                .shouldHave(statusCode(SC_OK))
                .shouldHave(responseSchema(SNAPSHOT_SCHEMA.getPath()));
    }

    @Test
    @Tag("smokeApi")
    void shouldBeAbleToGetSnapshotsForLayout() {
        layoutsRequests.getLayoutSnapshotsResponse(AGENT_KPI_LAYOUT_ID)
                .shouldHave(statusCode(SC_OK))
                .shouldHave(responseSchema(SNAPSHOT_SCHEMA.getPath()));
    }

}