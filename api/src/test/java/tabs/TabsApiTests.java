package tabs;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.tabs.TabsRequests;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_OK;
import static data.enums.jsonschemas.Schemas.TAB_RESPONSE_SCHEMA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static restwrapper.conditions.Conditions.responseSchema;
import static restwrapper.conditions.Conditions.statusCode;

@Tag("apiTabs")
@Tag("apiRegression")
class TabsApiTests {

    private final TabsRequests tabsRequests = new TabsRequests();
    private final String TAB_ID = "02004c4f4f50-8add-11ee-e6aa-8ac06f7f";

    @Test
    @Tag("smokeApi")
    void shouldBeAbleToGetTabs() {
        tabsRequests.getTabsResponse()
                .shouldHave(statusCode(SC_OK))
                .shouldHave(responseSchema(TAB_RESPONSE_SCHEMA.getPath()));
    }

    @Test
    @Tag("smokeApi")
    void shouldBeAbleToGetTabById() {
        var tab = tabsRequests.getTabById(TAB_ID);

        assertThat(tab.getBody().getGuid(), equalTo(TAB_ID));
    }

}