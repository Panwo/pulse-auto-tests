package pulse.logintests;


import com.codeborne.selenide.WebDriverRunner;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import properies.CommonConfig;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;

@Slf4j
public class BaseUiTest {

    public static final CommonConfig config = create(CommonConfig.class, getProperties());

    @BeforeAll
    public static void setUp() {
       /* Cookie ck = new Cookie("JSESSIONID", "en");
        WebDriverRunner.getWebDriver().manage().addCookie(ck);*/
        open(config.baseUrl());
    }

}