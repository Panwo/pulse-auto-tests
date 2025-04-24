package services;

import io.restassured.specification.RequestSpecification;
import restwrapper.response.AssertableResponse;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_OK;
import static files.FilesManager.deserialize;
import static restwrapper.commons.CustomRequestSpecification.baseCookieAuthWithLogging;
import static restwrapper.commons.CustomRequestSpecification.baseUriWithLogging;
import static restwrapper.conditions.Conditions.statusCode;

public class CommonRestRequests {

    public AssertableResponse getWithoutAuth(String path) {
        return new AssertableResponse(baseUriWithLogging().get(path));
    }

    public AssertableResponse getRequest(String path) {
        return new AssertableResponse(commonRequestSpecification()
                .get(path));
    }

    public AssertableResponse getRequestOk(String path) {
        return new AssertableResponse(commonRequestSpecification()
                .get(path))
                .shouldHave(statusCode(SC_OK));
    }

    public AssertableResponse postRequest(String path, String jsonFile) {
        return new AssertableResponse(commonRequestSpecification()
                .contentType("application/json")
                .body(deserialize(jsonFile))
                .post(path));
    }

    public AssertableResponse postRequest(String path) {
        return new AssertableResponse(commonRequestSpecification()
                .post(path));
    }

    public AssertableResponse deleteRequest(String path) {
        return new AssertableResponse(commonRequestSpecification()
                .delete(path));
    }

    private RequestSpecification commonRequestSpecification() {
        return baseCookieAuthWithLogging();
    }

}