package services.templates;

import restwrapper.response.AssertableResponse;
import services.RestClient;
import services.models.template.TemplateResponse;

import java.util.List;

import static data.enums.endpoints.TemplatesApi.*;
import static data.enums.requests.CreateRequestsData.TEMPLATE;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static restwrapper.conditions.Conditions.statusCode;

public class TemplatesRequests extends RestClient {

    public String createTemplate() {
        return postRequest(TEMPLATES.getEndpoint(), TEMPLATE.getBody())
                .shouldHave(statusCode(SC_CREATED))
                .getResponseAsPojo(TemplateResponse.class)
                .getDefinition().getGuid();
    }

    public AssertableResponse getTemplates() {
        return getRequest(TEMPLATES.getEndpoint());
    }

    public AssertableResponse getTemplateById(String guid) {
        return getRequest(format(TEMPLATES_GUID.getEndpoint(), guid));
    }

    public List<TemplateResponse> getTemplatesWithTypeAsList(String type) {
        return getTemplatesWithType(type)
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

    public AssertableResponse getTemplatesWithUscn(Number uscn) {
        return getRequest(format(TEMPLATES_USCN.getEndpoint(), uscn.toString()));
    }

    public AssertableResponse getTemplatesWithType(String type) {
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