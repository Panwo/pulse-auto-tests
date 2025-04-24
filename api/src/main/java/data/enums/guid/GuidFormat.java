package data.enums.guid;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GuidFormat {

    GUID_FORMAT("^[a-fA-F0-9]{12}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{8}$");

    private final String regex;

}