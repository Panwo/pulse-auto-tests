package restwrapper.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.net.URL;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

@RequiredArgsConstructor
public class ResponseSchemaCondition implements Condition{

    private final InputStream file;
    @Override
    @SneakyThrows
    public void check(Response response) {
        response.then().assertThat().body(matchesJsonSchema(file));
    }

}