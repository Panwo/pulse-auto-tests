package services.snapshots;

import restwrapper.response.AssertableResponse;
import services.RestClient;
import services.models.snapshots.SnapshotsResponse;

import java.util.List;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_OK;
import static data.enums.endpoints.LayoutsApi.LAYOUT_GUID_SNAPSHOT;
import static data.enums.endpoints.LayoutsApi.LAYOUT_GUID_SNAPSHOTS;
import static java.lang.String.format;
import static restwrapper.conditions.Conditions.statusCode;

public class SnapshotsRequests extends RestClient {

    public AssertableResponse getSnapshotResponse(String layoutId){
        return getRequest(format(LAYOUT_GUID_SNAPSHOT.getEndpoint(), layoutId));
    }

    public AssertableResponse getSnapshotsResponse(String layoutId){
        return getRequest(format(LAYOUT_GUID_SNAPSHOTS.getEndpoint(), layoutId));
    }

    public List<SnapshotsResponse> getSnapshots(String layoutId){
        return getRequest(format(LAYOUT_GUID_SNAPSHOTS.getEndpoint(), layoutId))
                .shouldHave(statusCode(SC_OK))
                .getResponseAsList(SnapshotsResponse[].class);
    }

}