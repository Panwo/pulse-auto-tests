package restwrapper.commons;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import Utils.test.UserCredentialsDto;
import io.restassured.specification.RequestSpecification;
import properies.CommonConfig;

import static Utils.test.CredentialUtils.*;
import static io.restassured.RestAssured.given;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;

public class CustomRequestSpecification {

    public static final CommonConfig config = create(CommonConfig.class, getProperties());

    public static RequestSpecification baseCookieAuthWithoutLogging(){
      return given()
              .filters(new RequestLoggingFilter(LogDetail.ALL, true, System.out),
                      new ResponseLoggingFilter(LogDetail.ALL, true, System.out))
              .baseUri(config.baseUrl())
              .relaxedHTTPSValidation()
              .header(authenthificationHeader());
    }

    public static Header authenthificationHeader() {
        final var credentialsDto = UserCredentialsDto.builder()
                .userName("default")
                .password("password")
                .build();
        return new Header("Cookie", "JSESSIONID=" + getCookie(credentialsDto).getCookie("JSESSIONID"));
    }

}