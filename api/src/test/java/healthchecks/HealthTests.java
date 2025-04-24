package healthchecks;

import org.junit.jupiter.api.Test;
import services.CommonRestRequests;
import services.models.healthcheck.HealthStatusResponse;

import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK;
import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK_DETAILS;
import static services.responcevalidators.HealthCheckValidator.assertValidHealthCheck;

class HealthTests {

    private final CommonRestRequests commonRestRequests = new CommonRestRequests();

    @Test
    void checkHealth() {
        commonRestRequests.getRequestOk(HEALTH_CHECK.getPath());
    }

    @Test
    void checkHealthDetails() {
        assertValidHealthCheck(commonRestRequests.getRequestOk(HEALTH_CHECK_DETAILS.getPath())
                .getResponseAsPojo(HealthStatusResponse.class));
    }

}