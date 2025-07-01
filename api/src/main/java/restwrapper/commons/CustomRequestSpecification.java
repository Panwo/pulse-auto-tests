package restwrapper.commons;

import Utils.UserCredentialsDto;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import properies.CommonConfig;

import static Utils.SessionManager.getSessionId;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;

public class CustomRequestSpecification {

    public static final CommonConfig config = create(CommonConfig.class, getProperties());

    public static RequestSpecification baseUrlWithLogging() {
        return given()
                .filters(new RequestLoggingFilter(LogDetail.ALL, true, System.out),
                        new ResponseLoggingFilter(LogDetail.ALL, true, System.out))
                .baseUri(config.api());
    }

    public static RequestSpecification baseRequest(UserCredentialsDto user) {
        return baseUrlWithLogging()
                .header("Cookie", "JSESSIONID=" + getSessionId(user))
                .contentType(JSON);
    }

}