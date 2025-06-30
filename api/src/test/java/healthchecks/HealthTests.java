package healthchecks;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.healthcheck.HealthCheckRequests;
import services.models.healthcheck.Collector;
import services.models.healthcheck.HealthStatusResponse;
import services.models.healthcheck.StatServer;

import java.util.stream.Stream;

import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK;
import static java.lang.Integer.parseInt;
import static java.util.stream.Stream.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("apiRegression")
@Tag("apiHealthChecks")
class HealthTests {

    private final HealthCheckRequests healthCheckRequests = new HealthCheckRequests();

    @Test
    @Tag("smokeApi")
    void checkHealth() {
        healthCheckRequests.getRequestOk(HEALTH_CHECK.getEndpoint());
    }

    @Test
    void checkHealthDetails() {
        var response = healthCheckRequests.getHealthStatus();

        assertCoreConnectionsStatus(response);

        response.getCollectors().values().forEach(collector -> {
            assertCollectorConnections(collector);
            assertSnapshotWritingStatus(collector);
            assertStatServerStatus(of(
                    collector.getConnectionStatus().getStatServer0(),
                    collector.getConnectionStatus().getStatServer1()));
        });
    }

    private void assertCoreConnectionsStatus(HealthStatusResponse response) {
        assertThat(response.getConfigServer().isConnected(), is(true));
        assertThat(response.getDatabase().isConnected(), is(true));
    }

    private void assertCollectorConnections(Collector collector) {
        assertThat(collector.getConnectionStatus().getConfigServer().isConnected(), is(true));
        assertThat(collector.getConnectionStatus().getDbServerConnection(), equalTo("online"));
        assertThat(collector.getConnectionStatus().getDbConnection2().isConnected(), is(true));
    }

    private void assertSnapshotWritingStatus(Collector collector) {
        assertThat(collector.isSnapshotWritingStatus(), is(true));
        assertThat(parseInt(collector.getActiveLayoutCount()), greaterThan(0));
    }

    private void assertStatServerStatus(Stream<StatServer> statServers) {
        assertThat(statServers.anyMatch(StatServer::isConnected), is(true));
    }

}