package templates;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import restwrapper.response.AssertableResponse;
import services.models.template.TemplateResponse;

import java.util.Optional;

import static com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus.*;
import static data.enums.endpoints.TemplatesApi.TEMPLATES;
import static data.enums.endpoints.TemplatesApi.TEMPLATES_GUID;
import static data.enums.requests.CreateRequestsData.TEMPLATE;
import static java.lang.String.format;
import static java.util.Optional.*;
import static restwrapper.conditions.Conditions.statusCode;
import static services.RestClient.*;

@Tag("apiTemplates")
@Tag("apiRegression")
class ModifyTemplatesTests {

    private String createdTemplateId;

    @Test
    @Tag("apiSmoke")
    void shouldBeAbleToCreateTemplate() {
        setCreatedTemplateId(postRequest(TEMPLATES.getEndpoint(), TEMPLATE.getBody())
                .shouldHave(statusCode(SC_CREATED)));
        safeDeleteTemplate();
    }

    @Test
    @Tag("apiSmoke")
    void shouldBeAbleToDeleteTemplate() {
        setCreatedTemplateId(postRequest(TEMPLATES.getEndpoint(), TEMPLATE.getBody())
                .shouldHave(statusCode(SC_CREATED)));
        safeDeleteTemplate();

        getRequest(format(TEMPLATES_GUID.getEndpoint(), createdTemplateId))
                .shouldHave(statusCode(SC_NOT_FOUND));
    }

    private void safeDeleteTemplate() {
        if (ofNullable(createdTemplateId)
                .map(id -> getRequest(format(TEMPLATES_GUID.getEndpoint(), id)).getResponse().getStatusCode())
                .filter(code -> code == 200)
                .isPresent()) {

            deleteRequest(format(TEMPLATES_GUID.getEndpoint(), createdTemplateId))
                    .shouldHave(statusCode(SC_OK));
        }
        createdTemplateId = null;
    }

    private void setCreatedTemplateId(AssertableResponse response) {
        createdTemplateId = response
                .getResponseAsPojo(TemplateResponse.class)
                .getDefinition().getGuid();
    }

}