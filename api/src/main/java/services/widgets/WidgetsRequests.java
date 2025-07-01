package services.widgets;

import restwrapper.response.AssertableResponse;
import services.RestClient;
import services.models.widgets.WidgetsResponse;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_OK;
import static data.enums.endpoints.WidgetsApi.WIDGETS;
import static data.enums.endpoints.WidgetsApi.WIDGET_GUID;
import static java.lang.String.format;
import static restwrapper.conditions.Conditions.statusCode;

public class WidgetsRequests extends RestClient {

    public AssertableResponse getWidgetsResponse() {
        return getRequest(WIDGETS.getEndpoint());
    }

    public WidgetsResponse getWidget(String id) {
        return getRequest(format(WIDGET_GUID.getEndpoint(), id))
                .shouldHave(statusCode(SC_OK))
                .getResponseAsPojo(WidgetsResponse.class);
    }

}