package data.enums.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OperationsApi {

    IMPORT("/api/wbrt/import"),
    EXPORT("/api/wbrt/export");

    private final String path;

}