package widgets;

import org.junit.jupiter.api.Test;
import services.CommonRestRequests;

import static data.enums.ApiPaths.TEMPLATES;
import static data.enums.ApiPaths.USERS;
import static data.enums.SchemasPaths.USER;
import static restwrapper.conditions.Conditions.responseSchema;

class TemplatesTests {

    private final CommonRestRequests commonRestRequests = new CommonRestRequests();
    private static final int TEMPLATES_COUNT = 89;

    @Test
    void shouldCheckTemplatesAccess(){
        commonRestRequests.getRequest(TEMPLATES.getPath())
                .shouldHave(responseSchema(getClass().getClassLoader()
                        .getResourceAsStream(USER.getSchema())));
    }

}
