package templates;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.templates.TemplatesRequests;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_BAD_REQUEST;
import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;
import static data.enums.endpoints.TemplatesApi.TEMPLATES_GUID;
import static data.enums.requests.TemplatesBody.*;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.hamcrest.Matchers.*;
import static restwrapper.conditions.Conditions.body;
import static restwrapper.conditions.Conditions.statusCode;

@Tag("apiTemplates")
@Tag("apiRegression")
class ModifyTemplatesTests {

    private String createdTemplateId;
    private final TemplatesRequests templatesRequests = new TemplatesRequests();

    @Test
    @Tag("apiSmoke")
    void shouldBeAbleToCreateTemplate() {
        createdTemplateId = templatesRequests.createDefaultTemplate();
        templatesRequests.safeDeleteTemplate(createdTemplateId);
    }

    @Test
    @Tag("apiSmoke")
    void shouldBeAbleToDeleteTemplate() {
        createdTemplateId = templatesRequests.createDefaultTemplate();
        templatesRequests.safeDeleteTemplate(createdTemplateId);

        templatesRequests.getTemplateByIdResponse(createdTemplateId)
                .shouldHave(statusCode(SC_NOT_FOUND));
    }

    @Test
    void shouldNotDeleteTemplateThatWasAlreadyDeleted() {
        createdTemplateId = templatesRequests.createDefaultTemplate();
        templatesRequests.safeDeleteTemplate(createdTemplateId);

        templatesRequests.deleteRequest(format(TEMPLATES_GUID.getEndpoint(), createdTemplateId))
                .shouldHave(statusCode(SC_NO_CONTENT));
    }

    @Test
    void shouldGetJsonParseErrorWhenFormatInvalid() {
        templatesRequests.createTemplateAndGetResponse(INVALID_TEMPLATE_FORMAT_BODY.getBody())
                .shouldHave(statusCode(SC_BAD_REQUEST))
                .shouldHave(body("message", equalTo("JSON_PARSE_ERROR")));
    }

    @Test
    void shouldGetInvalidDefinitionErrorWhenDefinitionInvalid() {
        templatesRequests.createTemplateAndGetResponse(INVALID_LAYOUT_DEFINITION_TEMPLATE_BODY.getBody())
                .shouldHave(statusCode(SC_BAD_REQUEST))
                .shouldHave(body("message", equalTo("INVALID_LAYOUT_DEFINITION")));
    }

    @Test
    void shouldGetObjectNameConflictWhenTemplateExists() {
        templatesRequests.createDefaultTemplate();
        templatesRequests.createTemplateAndGetResponse(TEMPLATE.getBody())
                .shouldHave(statusCode(SC_BAD_REQUEST))
                .shouldHave(body("message", equalTo("OBJECT_NAME_CONFLICT")));
        templatesRequests.safeDeleteTemplate(createdTemplateId);
    }

}