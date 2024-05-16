package widgets;

import org.junit.jupiter.api.Test;
import services.CommonRestRequests;

import static data.enums.ApiPaths.USERS;
import static data.enums.SchemasPaths.USER;
import static restwrapper.conditions.Conditions.responseSchema;

class UsersTests {

    private final CommonRestRequests requests = new CommonRestRequests();

    @Test
    void shouldGetUsersList() {
        requests.getRequest(USERS.getPath())
                .shouldHave(responseSchema(getClass().getClassLoader()
                        .getResourceAsStream(USER.getSchema())));
    }
}