package services;

import Utils.UserCredentialsDto;
import lombok.experimental.UtilityClass;
import restwrapper.response.AssertableResponse;

import static Utils.Users.getDefaultUser;
import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_OK;
import static restwrapper.commons.CustomRequestSpecification.baseRequest;
import static restwrapper.commons.CustomRequestSpecification.baseUrlWithLogging;
import static restwrapper.conditions.Conditions.statusCode;
import static files.FilesManager.deserialize;
@UtilityClass
public class RestClient {

    public static AssertableResponse getRequest(String path) {
        return getRequest(path, getDefaultUser());
    }

    public static AssertableResponse getRequest(String path, UserCredentialsDto user) {
        return new AssertableResponse(baseRequest(user).get(path));
    }

    public AssertableResponse getWithoutAuth(String path) {
        return new AssertableResponse(baseUrlWithLogging().get(path));
    }

    public AssertableResponse getRequestOk(String path) {
        return getRequest(path, getDefaultUser())
                .shouldHave(statusCode(SC_OK));
    }

    public AssertableResponse postRequest(String path, String jsonFile) {
        return postRequest(path, getDefaultUser(), jsonFile);
    }

    public AssertableResponse postRequest(String path) {
        return postRequest(path, getDefaultUser(), null);
    }

    public AssertableResponse postRequest(String path, UserCredentialsDto user, String jsonFile) {
        return new AssertableResponse(baseRequest(user)
                .body(deserialize(jsonFile))
                .post(path));
    }

    public AssertableResponse deleteRequest(String path) {
        return new AssertableResponse(baseRequest(getDefaultUser())
                .delete(path));
    }

}