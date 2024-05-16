package restwrapper.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matcher;

import static org.apache.commons.lang3.StringUtils.isBlank;

@RequiredArgsConstructor
public class BodyCondition implements Condition  {

    private final String bodyPath;
    private final Matcher<?> matcher;

    BodyCondition(Matcher<?> matcher) {
        this(null, matcher);
    }

    @Override
    public void check(Response response) {
        if (isBlank(bodyPath)) {
            response.then().assertThat().body(matcher);
        } else {
            response.then().assertThat().body(bodyPath, matcher);
        }
    }

    @Override
    public String toString() {
        if (isBlank(bodyPath)) {
            return "matcher = " + matcher.toString();
        } else {
            return "body path = " + bodyPath + " with value " + matcher.toString();
        }
    }

}
