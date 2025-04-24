package restwrapper.conditions;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class ContentTypeCondition implements Condition{

    private final String expectedContentType;

    @Override
    public void check(Response response) {
        response.then().assertThat().contentType(expectedContentType);
    }

}