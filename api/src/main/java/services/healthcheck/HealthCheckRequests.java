package services.healthcheck;

import restwrapper.response.AssertableResponse;
import services.RestClient;
import services.models.healthcheck.HealthStatusResponse;

import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK;
import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK_DETAILS;

public class HealthCheckRequests extends RestClient {

    public AssertableResponse getHealthResponse() {
        return getRequest(HEALTH_CHECK.getEndpoint());
    }

    public HealthStatusResponse getHealthStatus() {
        return getRequestOk(HEALTH_CHECK_DETAILS.getEndpoint())
                .getResponseAsPojo(HealthStatusResponse.class);
    }

}