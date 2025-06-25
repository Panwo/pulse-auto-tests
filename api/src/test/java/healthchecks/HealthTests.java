package healthchecks;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.models.healthcheck.HealthStatusResponse;

import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK;
import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK_DETAILS;
import static services.RestClient.*;
import static services.responcevalidators.HealthCheckValidator.assertValidHealthCheck;

@Tag("healthCheck")
class HealthTests {

    @Test
    void checkHealth() {
        getRequestOk(HEALTH_CHECK.getEndpoint());
    }

    @Test
    void checkHealthDetails() {
        assertValidHealthCheck(getRequestOk(HEALTH_CHECK_DETAILS.getEndpoint())
                .getResponseAsPojo(HealthStatusResponse.class));
    }

}