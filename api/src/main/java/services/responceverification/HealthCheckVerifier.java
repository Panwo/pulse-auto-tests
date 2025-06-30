package services.responceverification;

import lombok.experimental.UtilityClass;
import services.models.healthcheck.Collector;
import services.models.healthcheck.HealthStatusResponse;
import services.models.healthcheck.StatServer;

import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Stream.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@UtilityClass
public class HealthCheckVerifier {

    public static void assertValidHealthCheck(HealthStatusResponse response) {
        assertCoreConnectionsStatus(response);

        response.getCollectors().values().forEach(
                collector -> {
                    assertCollectorConnections(collector);
                    assertSnapshotWritingStatus(collector);
                    assertStatServerStatus(of(collector.getConnectionStatus().getStatServer0(),
                            collector.getConnectionStatus().getStatServer1()));
                }
        );
    }

    private static void assertCoreConnectionsStatus(HealthStatusResponse response) {
        assertThat(response.getConfigServer().isConnected(), is(true));
        assertThat(response.getDatabase().isConnected(), is(true));
    }

    private static void assertCollectorConnections(Collector collector) {
        assertThat(collector.getConnectionStatus().getConfigServer().isConnected(), is(true));
        assertThat(collector.getConnectionStatus().getDbServerConnection(), equalTo("online"));
        assertThat(collector.getConnectionStatus().getDbConnection2().isConnected(), is(true));
    }

    private static void assertSnapshotWritingStatus(Collector collector) {
        assertThat(collector.isSnapshotWritingStatus(), is(true));
        assertThat(parseInt(collector.getActiveLayoutCount()), greaterThan(0));
    }

    private static void assertStatServerStatus(Stream<StatServer> statServers) {
        assertThat(statServers.anyMatch(StatServer::isConnected), is(true));
    }

}