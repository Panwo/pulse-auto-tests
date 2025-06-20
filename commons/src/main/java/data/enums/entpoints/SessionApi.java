package data.enums.entpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SessionApi {

    LOGIN("/session/login"),
    LOGOUT("/session/logout");

    private final String path;

}