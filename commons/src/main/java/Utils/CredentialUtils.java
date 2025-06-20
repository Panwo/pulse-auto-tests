package Utils;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import properies.CommonConfig;

import java.util.Map;

import static data.enums.entpoints.SessionApi.LOGIN;
import static io.restassured.RestAssured.given;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;

@UtilityClass
public class CredentialUtils {

    private final CommonConfig config = create(CommonConfig.class, getProperties());

    public Response loginAs(UserCredentialsDto dto) {
        return given().
                header("Content-Type", "application/json")
                .body(Map.of("username", dto.getUserName(),
                             "password", dto.getPassword()))
                .post(config.api() + LOGIN.getPath());
    }

}