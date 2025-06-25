package users;

import jdk.jfr.Label;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.models.users.UsersResponse;

import static data.enums.endpoints.UsersApi.*;
import static data.enums.guid.GuidFormat.GUID_FORMAT;
import static data.enums.jsonschemas.Schemas.USER_RESPONSE_SCHEMA;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.junit.Assert.*;
import static restwrapper.conditions.Conditions.*;
import static services.RestClient.*;

@Tag("apiUsers")
class UsersTests {

    private final String FAKE_USER_ID = "02004c4f4f50-8c74-11f4-ab2e-460fbe4d";
    private final String EXISTING_USER_ID = "02004c4f4f50-8c74-11f4-ab2e-460fbe41";

    @Test
    @Tag("smoke")
    @Label("some dbid`s are missing")
    void shouldGetUsersList() {
        getRequestOk(USERS.getEndpoint())
                .shouldHave(contentType("application/json"))
                .shouldHave(responseSchema(USER_RESPONSE_SCHEMA.getPath()));
    }

    @Test
    void shouldReturnMethodNotAllowed() {
        postRequest(USERS.getEndpoint())
                .shouldHave(statusCode(SC_METHOD_NOT_ALLOWED));
    }

    @Test
    void shouldReturnUserNotFound() {
        getRequest(format(USERS_GUID.getEndpoint(), FAKE_USER_ID))
                .shouldHave(statusCode(SC_NOT_FOUND));
    }

    @Test
    void shouldReturnUserById() {
        var user = getRequestOk(format(USERS_GUID.getEndpoint(), EXISTING_USER_ID))
                .getResponseAsPojo(UsersResponse.class);

        assertEquals(EXISTING_USER_ID, user.getBody().getGuid());
    }

    @Test
    void shouldReturnTabsInfo() {
        var tabs = getRequestOk(format(USERS_GUID_BRIEF_DISABLED.getEndpoint(), EXISTING_USER_ID))
                .getResponseAsPojo(UsersResponse.class).getBody().getTab();

        assertFalse(tabs.isEmpty());
        assertTrue(tabs.stream().allMatch(tab -> tab.getBody().getGuid().matches(GUID_FORMAT.getRegex())));
    }

}