package services.tabs;

import data.enums.endpoints.TabsApi;
import restwrapper.response.AssertableResponse;
import services.RestClient;
import services.models.tabs.TabsResponse;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_OK;
import static data.enums.endpoints.TabsApi.*;
import static data.enums.endpoints.TabsApi.TABS;
import static java.lang.String.format;
import static restwrapper.conditions.Conditions.statusCode;

public class TabsRequests extends RestClient {

    public AssertableResponse getTabsResponse() {
        return getRequest(TABS.getEndpoint());
    }

    public AssertableResponse getTabsByIdResponse(String id) {
        return getRequest(format(TAB_GUID.getEndpoint(), id));
    }

    public TabsResponse getTabById(String id) {
        return getTabsByIdResponse(id)
                .shouldHave(statusCode(SC_OK))
                .getResponseAsPojo(TabsResponse.class);
    }

}