package templates;

import data.enums.DefaultTemplatesNames;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import services.templates.TemplatesRequests;

import java.util.stream.Stream;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_BAD_REQUEST;
import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_OK;
import static data.enums.jsonschemas.Schemas.TEMPLATE_RESPONSE_SCHEMA;
import static java.util.Arrays.stream;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.of;
import static restwrapper.conditions.Conditions.*;

@Tag("apiTemplates")
@Tag("apiRegression")
class ReadTemplatesTests {

    private static final String EXISTING_TEMPLATE_GUID = "000000000000-0000-0000-0000-00000008";
    private static final int FILTER_USCN = 1430;
    private final TemplatesRequests templatesRequests = new TemplatesRequests();

    @Test
    @Tag("smokeApi")
    void shouldGetTemplates() {
        templatesRequests.getTemplates()
                .shouldHave(statusCode(SC_OK))
                .shouldHave(responseSchema(TEMPLATE_RESPONSE_SCHEMA.getPath()));
    }

    @Test
    void shouldHaveDefaultTemplates() {
        var defaultTemplates = stream(DefaultTemplatesNames.values())
                .map(DefaultTemplatesNames::getType).toArray(String[]::new);

        templatesRequests.getTemplates()
                .shouldHave(body("definition.name", hasItems(defaultTemplates)));
    }

    @Test
    void shouldGetTemplateByGuid() {
        templatesRequests.getTemplateById(EXISTING_TEMPLATE_GUID)
                .shouldHave(body("definition.guid", is(EXISTING_TEMPLATE_GUID)));
    }

    @ParameterizedTest
    @MethodSource("typesWithExpectations")
    void shouldGetTemplateByType(String templateType) {
        var templates = templatesRequests.getTemplatesWithTypeAsList(templateType);

        assertTrue(templates.isEmpty() || templates.stream()
                .allMatch(template -> template.getDefinition().getLayoutType().equals(templateType)));
    }

    @Test
    void shouldReturnBadRequestForUnknownTemplateType() {
        templatesRequests.getTemplatesWithType("ltREGULAR")
                .shouldHave(statusCode(SC_BAD_REQUEST));
    }

    @Test
    void shouldFilterTemplatesByUscn() {
        var templates = templatesRequests.getTemplatesWithUscn(FILTER_USCN);

        assertTrue(templates.stream().allMatch(template -> template.getState().getUscn() > FILTER_USCN));
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