package data.enums.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HealthChecksApi {

    HEALTH_CHECK("/plugins/wbrt/health"),
    HEALTH_CHECK_DETAILS("/plugins/wbrt/health/detail");

    private final String endpoint;

}