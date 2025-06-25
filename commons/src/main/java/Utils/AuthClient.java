package Utils;

import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import properies.CommonConfig;

import java.util.Map;

import static data.enums.entpoints.SessionApi.LOGIN;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.*;
import static java.lang.System.getProperties;
import static java.lang.System.getenv;
import static org.aeonbits.owner.ConfigFactory.create;

@UtilityClass
public class AuthClient {

    private final CommonConfig config = create(CommonConfig.class, getProperties());

    public Response loginAs(UserCredentialsDto dto) {
        return given()
                .contentType(JSON)
                .body(Map.of("username", dto.getUserName(),
                             "password", dto.getPassword()))
                .post(config.api() + LOGIN.getPath());
    }

    public String requireEnv(String key) {
        String value = getenv(key);
        if (value == null)
            throw new IllegalStateException("Missing required environment variable: " + key);
        return value;
    }

}