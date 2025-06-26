package healthchecks;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.healthcheck.HealthCheckRequests;

import static org.apache.http.HttpStatus.SC_OK;
import static restwrapper.conditions.Conditions.statusCode;
import static services.responcevalidators.HealthCheckValidator.assertValidHealthCheck;

@Tag("healthCheck")
class HealthTests {

    private final HealthCheckRequests healthCheckRequests = new HealthCheckRequests();

    @Test
    void checkHealth() {
        healthCheckRequests.getHealthResponse()
                .shouldHave(statusCode(SC_OK));
    }

    @Test
    void checkHealthDetails() {
        assertValidHealthCheck(healthCheckRequests.getHealthStatus());
    }

}