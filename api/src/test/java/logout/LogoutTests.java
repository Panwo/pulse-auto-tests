package logout;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static Utils.AuthClient.loginAs;
import static Utils.Users.getDefaultUser;
import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_NO_CONTENT;
import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_UNAUTHORIZED;
import static data.enums.entpoints.SessionApi.LOGOUT;
import static restwrapper.conditions.Conditions.statusCode;
import static services.RestClient.*;

@Tag("apiLogout")
class LogoutTests {

    @Test
    @Tag("smokeApi")
    void shouldBeAbleToLogOut() {
        loginAs(getDefaultUser());
        getRequest(LOGOUT.getPath())
                .shouldHave(statusCode(SC_NO_CONTENT));
    }

    @Test
    void shouldFailLogoutWhenSessionIsInactive() {
        getWithoutAuth(LOGOUT.getPath())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

}