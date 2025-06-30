package login;

import Utils.UserCredentialsDto;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static Utils.AuthClient.loginAs;
import static Utils.Users.getDefaultUser;
import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_NO_CONTENT;
import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_UNAUTHORIZED;
import static java.lang.System.*;

@Tag("apiLogin")
@Tag("apiRegression")
class LoginTests {

    @Test
    @Tag("smokeApi")
    void shouldBeAbleToLogin() {
        loginAs(getDefaultUser()).then().statusCode(SC_NO_CONTENT);
    }

    @Test
    void shouldFailToLoginWithInvalidCredentials() {
        var defaultUserWithoutPassword = UserCredentialsDto.builder()
                .userName(getenv("PulseUser"))
                .password("")
                .build();

        loginAs(defaultUserWithoutPassword).then().statusCode(SC_UNAUTHORIZED);
    }

}