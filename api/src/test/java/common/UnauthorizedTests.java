package common;

import org.junit.jupiter.api.Test;
import services.CommonRestRequests;

import static data.enums.endpoints.LayoutsApi.LAYOUTS;
import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK;
import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK_DETAILS;
import static data.enums.jsonschemas.Schemas.*;
import static data.enums.endpoints.TabsApi.TABS;
import static data.enums.endpoints.TemplatesApi.TEMPLATES;
import static data.enums.endpoints.UsersApi.USERS;
import static data.enums.endpoints.WidgetsApi.WIDGETS;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static restwrapper.conditions.Conditions.responseSchema;
import static restwrapper.conditions.Conditions.statusCode;

public class UnauthorizedTests {

    private final CommonRestRequests commonRestRequests = new CommonRestRequests();

    @Test
    void shouldReturnUnauthorizedWhenAccessingTemplatesWithoutAuth() {
        commonRestRequests.getWithoutAuth(TEMPLATES.getPath())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingLayoutsWithoutAuth() {
        commonRestRequests.getWithoutAuth(LAYOUTS.getPath())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingWidgetsWithoutAuth() {
        commonRestRequests.getWithoutAuth(WIDGETS.getPath())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingTabsWithoutAuth() {
        commonRestRequests.getWithoutAuth(TABS.getPath())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingUsersWithoutAuth() {
        commonRestRequests.getWithoutAuth(USERS.getPath())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnResponseWhenAccessingHealthWithoutAuth() {
        commonRestRequests.getWithoutAuth(HEALTH_CHECK.getPath())
                .shouldHave(statusCode(SC_OK));
    }

    @Test
    void shouldReturnResponseWhenAccessingHealthDetailsWithoutAuth() {
        commonRestRequests.getWithoutAuth(HEALTH_CHECK_DETAILS.getPath())
                .shouldHave(responseSchema(HEALTH_RESPONSE_SCHEMA.getPath()));
    }

}