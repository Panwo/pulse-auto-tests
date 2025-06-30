package services.templates;

import restwrapper.response.AssertableResponse;
import services.RestClient;
import services.models.template.TemplateResponse;

import java.util.List;

import static data.enums.endpoints.TemplatesApi.*;
import static data.enums.requests.TemplatesBody.TEMPLATE;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static restwrapper.conditions.Conditions.statusCode;

public class TemplatesRequests extends RestClient {

    public String createDefaultTemplate() {
        return createTemplateAndGetResponse(TEMPLATE.getBody())
                .shouldHave(statusCode(SC_CREATED))
                .getResponseAsPojo(TemplateResponse.class)
                .getDefinition().getGuid();
    }

    public AssertableResponse createTemplateAndGetResponse(String templateBodyPath) {
        return postRequest(TEMPLATES.getEndpoint(), templateBodyPath);
    }

    public AssertableResponse getTemplatesResponse() {
        return getRequest(TEMPLATES.getEndpoint());
    }

    public AssertableResponse getTemplateByIdResponse(String guid) {
        return getRequest(format(TEMPLATES_GUID.getEndpoint(), guid));
    }

    public List<TemplateResponse> getTemplatesWithTypeAsList(String type) {
        return getTemplatesWithTypeResponse(type)
                .shouldHave(statusCode(SC_OK))
                .getResponseAsList(TemplateResponse[].class);
    }

    public List<TemplateResponse> getTemplatesWithUscnAsList(long uscn) {
        return getRequestOk(format(TEMPLATES_USCN.getEndpoint(), uscn))
                .getResponseAsList(TemplateResponse[].class);
    }

    public List<TemplateResponse> getTemplatesWithUscnAndTypeAsList(long uscn, String type) {
        return getRequestOk(format(TEMPLATES_USCN_TYPE.getEndpoint(), uscn, type))
                .shouldHave(statusCode(SC_OK))
                .getResponseAsList(TemplateResponse[].class);
    }

    public AssertableResponse getTemplatesWithUscnResponse(Number uscn) {
        return getRequest(format(TEMPLATES_USCN.getEndpoint(), uscn.toString()));
    }

    public AssertableResponse getTemplatesWithTypeResponse(String type) {
        return getRequest(format(TEMPLATES_TYPE.getEndpoint(), type));
    }

    public void safeDeleteTemplate(String id) {
        if (templateExists(id)) {
            deleteRequest(format(TEMPLATES_GUID.getEndpoint(), id))
                    .shouldHave(statusCode(SC_OK));
        }
    }

    private boolean templateExists(String id) {
        return getRequest(format(TEMPLATES_GUID.getEndpoint(), id))
                .getResponse().getStatusCode() == SC_OK;
    }

}