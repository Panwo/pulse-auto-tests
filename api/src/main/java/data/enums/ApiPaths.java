package data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiPaths {

    USERS("/wbrt/users"),
    WIDGETS("/wbrt/widgets"),
    TEMPLATES("/wbrt/templates"),
    LAYOUTS("/wbrt/layouts"),
    TABS("/wbrt/tabs"),
    IMPORT("/wbrt/import"),
    EXPORT("wbrt/export"),
    HEALTH("/plugins/wbrt/health"),
    HEALTH_DETAILS("/plugins/wbrt/health/detail");

    private final String path;

}