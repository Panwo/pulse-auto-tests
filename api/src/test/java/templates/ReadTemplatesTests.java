package templates;

import data.enums.DefaultTemplatesNames;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import services.templates.TemplatesRequests;

import java.math.BigInteger;
import java.util.stream.Stream;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_BAD_REQUEST;
import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_OK;
import static data.enums.jsonschemas.Schemas.TEMPLATE_RESPONSE_SCHEMA;
import static java.lang.Long.MAX_VALUE;
import static java.util.Arrays.stream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.params.provider.Arguments.of;
import static restwrapper.conditions.Conditions.*;

@Tag("apiTemplates")
@Tag("apiRegression")
class ReadTemplatesTests {

    private final long VALID_USCN = 1430;
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
                .map(DefaultTemplatesNames::getType)
                .toArray(String[]::new);

        templatesRequests.getTemplates()
                .shouldHave(body("definition.name", hasItems(defaultTemplates)));
    }

    @ParameterizedTest
    @MethodSource("typesWithExpectations")
    void shouldGetTemplatesByType(String templateType) {
        var templates = templatesRequests.getTemplatesWithTypeAsList(templateType);

        var allMatchType = templates.stream()
                .allMatch(template -> template.getDefinition().getLayoutType().equals(templateType));

        assertThat(templates.isEmpty() || allMatchType, is(true));
    }

    @Test
    void shouldReturnBadRequestForUnknownTemplateType() {
        templatesRequests.getTemplatesWithType("ltREGULAR")
                .shouldHave(statusCode(SC_BAD_REQUEST));
    }

    @Test
    void shouldGetTemplatesByUscnAndType() {
        var regularTemplate = "ltPCREGULAR";

        var templatesFiltered = templatesRequests.getTemplatesWithUscnAndTypeAsList(VALID_USCN, regularTemplate)
                .stream()
                .allMatch(template -> template.getState().getUscn() > VALID_USCN
                        && template.getDefinition().getLayoutType().equals(regularTemplate));

        assertThat(templatesFiltered, is(true));
    }

    @Test
    void shouldFilterTemplatesByUscn() {
        var templates = templatesRequests.getTemplatesWithUscnAsList(VALID_USCN);

        var templatesFiltered = templates.stream()
                .allMatch(template -> template.getState().getUscn() > VALID_USCN);

        assertThat(templatesFiltered, is(true));
    }

    @Test
    void shouldReturnEmptyResponseForMaximumAllowedUscn() {
        var templates = templatesRequests.getTemplatesWithUscnAsList(MAX_VALUE);
        assertThat(templates.isEmpty(), is(true));
    }

    @ParameterizedTest
    @MethodSource("invalidUscnNumbers")
    void shouldReturnBadRequestWithInvalidUscn(Number uscn) {
        templatesRequests.getTemplatesWithUscn(uscn)
                .shouldHave(statusCode(SC_BAD_REQUEST));
    }

    @Test
    void shouldGetTemplateByGuid() {
        var EXISTING_TEMPLATE_GUID = "000000000000-0000-0000-0000-00000008";

        templatesRequests.getTemplateById(EXISTING_TEMPLATE_GUID)
                .shouldHave(body("definition.guid", is(EXISTING_TEMPLATE_GUID)));
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

    static Stream<Arguments> invalidUscnNumbers() {
        return Stream.of(
                of(new BigInteger("9223372036854775808")),
                of(-1)
        );
    }
}