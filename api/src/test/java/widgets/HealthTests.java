package widgets;

import data.enums.ApiPaths;
import org.junit.jupiter.api.Test;
import restwrapper.conditions.StatusCodeCondition;
import services.CommonRestRequests;

import static data.enums.ApiPaths.*;
import static restwrapper.conditions.Conditions.statusCode;

class HealthTests {

    private final CommonRestRequests commonRestRequests = new CommonRestRequests();
    @Test
    void checkHealth(){
        commonRestRequests.getRequest(HEALTH.getPath())
                .shouldHave(statusCode(200));
    }

}