package services.users;

import restwrapper.response.AssertableResponse;
import services.RestClient;
import services.models.users.UsersResponse;

import static data.enums.endpoints.UsersApi.USERS;
import static data.enums.endpoints.UsersApi.USERS_GUID;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;
import static restwrapper.conditions.Conditions.statusCode;

public class UsersRequests extends RestClient {

    public AssertableResponse getUsersResponse() {
        return getRequest(USERS.getEndpoint());
    }

    public AssertableResponse getUserByIdResponse(String id) {
        return getRequest(format(USERS_GUID.getEndpoint(), id));
    }

    public UsersResponse getUserByID(String id) {
        return getUserByIdResponse(id)
                .shouldHave(statusCode(SC_OK))
                .getResponseAsPojo(UsersResponse.class);
    }

}