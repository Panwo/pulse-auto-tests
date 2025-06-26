package templates;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import services.templates.TemplatesRequests;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;
import static restwrapper.conditions.Conditions.statusCode;

@Tag("apiTemplates")
@Tag("apiRegression")
class ModifyTemplatesTests {

    private String createdTemplateId;
    private final TemplatesRequests templatesRequests = new TemplatesRequests();

    @Test
    @Tag("apiSmoke")
    void shouldBeAbleToCreateTemplate() {
        createdTemplateId = templatesRequests.createTemplate();
        templatesRequests.safeDeleteTemplate(createdTemplateId);
    }

    @Test
    @Tag("apiSmoke")
    void shouldBeAbleToDeleteTemplate() {
        createdTemplateId = templatesRequests.createTemplate();
        templatesRequests.safeDeleteTemplate(createdTemplateId);

        templatesRequests.getTemplateById(createdTemplateId)
                .shouldHave(statusCode(SC_NOT_FOUND));
    }

}