package restwrapper.response;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import restwrapper.conditions.Condition;

import java.util.List;

import static java.util.Arrays.asList;

public class AssertableResponse {

    private final Response response;

    public AssertableResponse(Response response) {
        this.response = response;
    }

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    @SneakyThrows
    public <T> T getResponseAsPojo(Class<T> pojoClass) {
        var responseBody = response.body().asString();
        return new ObjectMapper().readValue(responseBody, pojoClass);
    }

    @SneakyThrows
    public <T> List<T> getResponseAsList(Class<T[]> arrayClass) {
        var responseBody = response.body().asString();
        return asList(new ObjectMapper().readValue(responseBody, arrayClass));
    }

    public String getValue(String jsonPath) {
        return response.jsonPath().getString(jsonPath);
    }

}