package services.layouts;

import restwrapper.response.AssertableResponse;
import services.RestClient;
import services.models.layouts.LayoutsResponse;

import static data.enums.endpoints.LayoutsApi.*;
import static java.lang.String.format;

public class LayoutsRequests extends RestClient {

    public AssertableResponse getLayoutsResponse() {
        return getRequest(LAYOUTS.getEndpoint());
    }

    public AssertableResponse getLayoutByIdResponse(String id) {
        return getRequest(format(LAYOUT_GUID.getEndpoint(), id));
    }

    public AssertableResponse getLayoutSnapshotResponse(String layoutId) {
        return getRequest(format(LAYOUT_GUID_SNAPSHOT.getEndpoint(), layoutId));
    }

    public AssertableResponse getLayoutSnapshotsResponse(String layoutId) {
        return getRequest(format(LAYOUT_GUID_SNAPSHOTS.getEndpoint(), layoutId));
    }

    public LayoutsResponse getLayouts() {
        return new LayoutsResponse();
    }

}