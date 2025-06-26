package security;

import org.junit.jupiter.api.Test;
import services.RestClient;

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

class UnauthorizedAccessTests {

    private final RestClient restClient = new RestClient();

    @Test
    void shouldReturnUnauthorizedWhenAccessingTemplatesWithoutAuth() {
        restClient.getWithoutAuth(TEMPLATES.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingLayoutsWithoutAuth() {
        restClient.getWithoutAuth(LAYOUTS.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingWidgetsWithoutAuth() {
        restClient.getWithoutAuth(WIDGETS.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingTabsWithoutAuth() {
        restClient.getWithoutAuth(TABS.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnUnauthorizedWhenAccessingUsersWithoutAuth() {
        restClient.getWithoutAuth(USERS.getEndpoint())
                .shouldHave(statusCode(SC_UNAUTHORIZED));
    }

    @Test
    void shouldReturnResponseWhenAccessingHealthWithoutAuth() {
        restClient.getWithoutAuth(HEALTH_CHECK.getEndpoint())
                .shouldHave(statusCode(SC_OK));
    }

    @Test
    void shouldReturnResponseWhenAccessingHealthDetailsWithoutAuth() {
        restClient.getWithoutAuth(HEALTH_CHECK_DETAILS.getEndpoint())
                .shouldHave(responseSchema(HEALTH_RESPONSE_SCHEMA.getPath()));
    }

}