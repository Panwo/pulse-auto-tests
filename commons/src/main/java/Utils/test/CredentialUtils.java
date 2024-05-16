package Utils.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.util.JSONPObject;
import properies.CommonConfig;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;

@UtilityClass
public class CredentialUtils {

    private final CommonConfig config = create(CommonConfig.class, getProperties());
    public Response getCookie(UserCredentialsDto dto) {
        return given().
                header("Content-Type", "application/json")
                .body(Map.of("username", dto.getUserName(),
                        "password", dto.getPassword()))
                .post(config.baseUrl() + "/session/login");
    }

}