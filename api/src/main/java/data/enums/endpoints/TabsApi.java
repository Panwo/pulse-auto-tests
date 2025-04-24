package data.enums.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TabsApi {

    TABS("/wbrt/tabs"),
    TABS_TYPE("/wbrt/tabs?type=%s"),
    TABS_SHARED("/wbrt/tabs/?shared=true"),
    TAB_BRIEF("/wbrt/tabs/?brief=%"),
    TAB_GET_WITH_PARAMETERS("/wbrt/tabs/?brief=%&shared=%&type=%"),
    TAB_POST_WITH_PARAMETERS("/wbrt/tabs/?brief=%&shared=%&overwrite=%"),
    TAB_GUID("/wbrt/tabs/%s"),
    TAB_GUID_BRIEF("/wbrt/tabs/%s?brief=%"),
    TAB_GUID_PUT_WITH_PARAMETERS("/wbrt/tabs/%s?brief=%&overwrite=%");

    private final String path;
}