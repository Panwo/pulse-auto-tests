package restwrapper.conditions;

import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;

@UtilityClass
public class Conditions {

    public static Condition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static BodyCondition body(String bodyPath, Matcher<?> matcher) {
        return new BodyCondition(bodyPath, matcher);
    }

    public static BodyCondition body(Matcher<?> matcher) {
        return new BodyCondition(matcher);
    }

    public static ResponseSchemaCondition responseSchema(String schemaUrl) {
        return new ResponseSchemaCondition(BodyCondition.class
                .getResourceAsStream("/" + schemaUrl));
    }

    public static ContentTypeCondition contentType(String contentType) {
        return new ContentTypeCondition(contentType);
    }

}