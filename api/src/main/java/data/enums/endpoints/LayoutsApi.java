package data.enums.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LayoutsApi {

    LAYOUTS("/wbrt/layouts"),
    LAYOUT_GUID("/wbrt/layouts/%s"),
    LAYOUT_GUID_SNAPSHOT("/wbrt/layouts/%s/snapshot"),
    LAYOUT_GUID_SNAPSHOTS("/wbrt/layouts/%s/snapshots"),
    LAYOUT_TYPE("/wbrt/layouts?type=%s"),
    LAYOUT_USCN("/wbrt/layouts?uscn=%s"),
    LAYOUT_USCN_TYPE("/wbrt/layouts?uscn=%s&type=%s");

    private final String endpoint;

}