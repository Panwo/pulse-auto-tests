package services.widgets;

import restwrapper.response.AssertableResponse;
import services.RestClient;

import static data.enums.endpoints.WidgetsApi.WIDGETS;

public class WidgetsRequests extends RestClient {

    public AssertableResponse getWidgetsResponse() {
        return getRequest(WIDGETS.getEndpoint());
    }

}