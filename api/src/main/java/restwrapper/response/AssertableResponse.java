package restwrapper.response;

import io.restassured.response.Response;
import restwrapper.conditions.Condition;

public class AssertableResponse {

 private final Response response;
    public AssertableResponse(Response response) {
        this.response = response;
    }

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

}