package services;

import io.restassured.specification.RequestSpecification;
import restwrapper.response.AssertableResponse;

import static restwrapper.commons.CustomRequestSpecification.baseCookieAuthWithoutLogging;

public class CommonRestRequests {

    public AssertableResponse getRequest(String path) {
        return new AssertableResponse(commonRequestSpecification()
                .get(path));
    }

    private RequestSpecification commonRequestSpecification() {
        return baseCookieAuthWithoutLogging();
    }

}