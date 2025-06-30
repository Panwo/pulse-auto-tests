package users;

import jdk.jfr.Label;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.users.UsersRequests;

import static data.enums.endpoints.UsersApi.USERS;
import static data.enums.guid.GuidFormat.GUID_FORMAT;
import static data.enums.jsonschemas.Schemas.USER_RESPONSE_SCHEMA;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.junit.Assert.*;
import static restwrapper.conditions.Conditions.*;

@Tag("apiUsers")
@Tag("apiRegression")
class UsersTests {

    private final String EXISTING_USER_ID = "02004c4f4f50-8c74-11f4-ab2e-460fbe41";
    private final UsersRequests usersRequests = new UsersRequests();

    @Test
    @Tag("smoke")
    @Label("some dbid`s are missing")
    void shouldGetUsersList() {
        usersRequests.getUsersResponse()
                .shouldHave(contentType("application/json"))
                .shouldHave(responseSchema(USER_RESPONSE_SCHEMA.getPath()));
    }

    @Test
    void shouldReturnMethodNotAllowed() {
        usersRequests.postRequest(USERS.getEndpoint())
                .shouldHave(statusCode(SC_METHOD_NOT_ALLOWED));
    }

    @Test
    void shouldReturnUserNotFound() {
        String UNEXISTING_ID = "02004c4f4f50-8c74-11f4-ab2e-460fbe4d";
        usersRequests.getUserByIdResponse(UNEXISTING_ID)
                .shouldHave(statusCode(SC_NOT_FOUND));
    }

    @Test
    void shouldReturnUserById() {
        var userGuid = usersRequests.getUserByID(EXISTING_USER_ID)
                .getBody()
                .getGuid();
        assertEquals(EXISTING_USER_ID, userGuid);
    }

    @Test
    void shouldReturnTabsInfo() {
        var tabs = usersRequests.getUserByID(EXISTING_USER_ID).getBody().getTab();

        assertFalse(tabs.isEmpty());
        assertTrue(tabs.stream().allMatch(tab -> tab.getBody().getGuid().matches(GUID_FORMAT.getRegex())));
    }

}