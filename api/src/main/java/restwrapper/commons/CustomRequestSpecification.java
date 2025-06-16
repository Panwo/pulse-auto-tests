package restwrapper.commons;

import Utils.test.UserCredentialsDto;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import properies.CommonConfig;

import static Utils.test.CredentialUtils.loginAs;
import static io.restassured.RestAssured.given;
import static java.lang.System.getProperties;
import static java.lang.System.getenv;
import static org.aeonbits.owner.ConfigFactory.create;

public class CustomRequestSpecification {

    public static final CommonConfig config = create(CommonConfig.class, getProperties());

    public static RequestSpecification baseCookieAuthWithLogging() {
      /* return new RequestSpecBuilder()
               .addFilters(of(new RequestLoggingFilter(LogDetail.ALL, true, System.out)))
               .setBaseUri(config.api())
               .setRelaxedHTTPSValidation()
               .build().header(authenthificationHeader());*/
        return baseUriWithLogging().header(authenthificationHeader());
    }

    public static RequestSpecification baseUriWithLogging() {
        return given()
                .filters(new RequestLoggingFilter(LogDetail.ALL, true, System.out),
                        new ResponseLoggingFilter(LogDetail.ALL, true, System.out))
                .baseUri(config.api());
    }

    private static Header authenthificationHeader() {
        var credentials = UserCredentialsDto.builder()
                .userName(getenv("PulseUser"))
                .password(getenv("PulsePassword"))
                .build();

        var cookies = loginAs(credentials).getCookie("JSESSIONID");

        return new Header("Cookie", "JSESSIONID=" + cookies);
    }

}