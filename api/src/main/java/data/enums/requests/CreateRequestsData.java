package data.enums.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CreateRequestsData {

    TEMPLATE("src/test/resources/requests/template.json");

    private final String body;

}