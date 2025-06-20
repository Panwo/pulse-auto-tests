package templates;

import data.enums.DefaultTemplatesNames;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import services.models.template.TemplateResponse;

import java.util.stream.Stream;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.*;
import static data.enums.endpoints.TemplatesApi.*;
import static data.enums.jsonschemas.Schemas.TEMPLATE;
import static java.lang.String.format;
import static java.util.Arrays.stream;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.of;
import static restwrapper.conditions.Conditions.body;
import static restwrapper.conditions.Conditions.statusCode;
import static services.RestClient.*;

class TemplatesTests {

    private static final String EXISTING_TEMPLATE_GUID = "000000000000-0000-0000-0000-00000008";
    private static final int FILTER_USCN = 1430;
    private static final String AUTOTEST_NAME = "Autotest";

    @Test
    void shouldCheckDefaultTemplatesPresence() {
        var defaultTemplates = stream(DefaultTemplatesNames.values())
                .map(DefaultTemplatesNames::getType).toArray(String[]::new);

        getRequestOk(TEMPLATES.getPath())
                .shouldHave(body("definition.name", hasItems(defaultTemplates)));
    }

    @Test
    void shouldGetTemplateByGuid() {
        getRequest(format(TEMPLATES_GUID.getPath(), EXISTING_TEMPLATE_GUID))
                .shouldHave(body("definition.guid", is(EXISTING_TEMPLATE_GUID)));
    }

    @ParameterizedTest
    @MethodSource("typesWithExpectations")
    void shouldReturnTemplatesMatchingType(String templateType) {
        var templates = getRequestOk(format(TEMPLATES_TYPE.getPath(), templateType))
                .getResponseAsList(TemplateResponse[].class);

        assertTrue(templates.isEmpty() || templates.stream()
                .allMatch(template -> template.getDefinition().getLayoutType().equals(templateType)));
    }

    @Test
    void shouldReturnBadRequestForUnknownTemplateType() {
        getRequest(format(format(TEMPLATES_TYPE.getPath(), "ltREGULAR")))
                .shouldHave(statusCode(SC_BAD_REQUEST));
    }

    @Test
    void shouldFilterByUscn() {
        var templates = getRequestOk(format(TEMPLATES_USCN.getPath(), FILTER_USCN))
                .getResponseAsList(TemplateResponse[].class);

        assertTrue(templates.stream().allMatch(template -> template.getState().getUscn() > FILTER_USCN));
    }

    @Test
    void shouldCreateTemplate() {
        postRequest(TEMPLATES.getPath(), TEMPLATE.getPath())
                .shouldHave(statusCode(SC_CREATED));
    }

    @AfterAll
    static void deleteTemplate() {
        var CREATED_TEMPLATE_GUID = getRequestOk(TEMPLATES.getPath())
                .getResponseAsList(TemplateResponse[].class).stream()
                .filter(template -> template.getDefinition().getName().equals(AUTOTEST_NAME))
                .findFirst().get().getDefinition().getGuid();
        deleteRequest(format(TEMPLATES_GUID.getPath(), CREATED_TEMPLATE_GUID))
                .shouldHave(statusCode(SC_OK));
    }

    static Stream<Arguments> typesWithExpectations() {
        return Stream.of(
                of("ltGENERIC"),
                of("ltPCREGULAR"),
                of("ltPCPERFORMANCE"),
                of("ltDATADEPOT"),
                of("ltIFRAME"),
                of("ltOTHER")
        );
    }

}