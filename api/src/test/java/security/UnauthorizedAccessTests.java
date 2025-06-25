package security;

import org.junit.jupiter.api.Test;

import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK;
import static data.enums.endpoints.HealthChecksApi.HEALTH_CHECK_DETAILS;
import static data.enums.endpoints.LayoutsApi.LAYOUTS;
import static data.enums.endpoints.TabsApi.TABS;
import static data.enums.endpoints.TemplatesApi.TEMPLATES;
import static data.enums.endpoints.UsersApi.USERS;
import static data.enums.endpoints.WidgetsApi.WIDGETS;
import static data.enums.jsonschemas.Schemas.HEALTH_RESPONSE_SCHEMA;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static restwrapper.conditions.Conditions.responseSchema;
import static restwrapper.conditions.Conditions.statusCode;
import static services.RestClient.getWithoutAuth;

class UnauthorizedAccessTests {

    @Test
    void shouldReturnUnauthorizedWhenAccessingTemplatesWithoutAuth() {
        getWithoutAuth(TEMPLATES.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingLayoutsWithoutAuth() {
        getWithoutAuth(LAYOUTS.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingWidgetsWithoutAuth() {
        getWithoutAuth(WIDGETS.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingTabsWithoutAuth() {
        getWithoutAuth(TABS.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingUsersWithoutAuth() {
        getWithoutAuth(USERS.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnResponseWhenAccessingHealthWithoutAuth() {
        getWithoutAuth(HEALTH_CHECK.getEndpoint())
                .shouldHave(statusCode(SC_OK));
    }

    @Test
    void shouldReturnResponseWhenAccessingHealthDetailsWithoutAuth() {
        getWithoutAuth(HEALTH_CHECK_DETAILS.getEndpoint())
                .shouldHave(responseSchema(HEALTH_RESPONSE_SCHEMA.getPath()));
    }

}