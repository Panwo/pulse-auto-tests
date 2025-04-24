package pulse.logintests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;


class LoginTest extends BaseUiTest {

    private final String LOGIN = "paramonov.vdp@gmail.com";
    private final String PASSWORD = "";

    @Test
    void register() {

        $x("//input[contains(@class,'ark-login-username')]").sendKeys("default");
        $x("//input[contains(@class, 'ark-login-password')]").sendKeys("password");
        $x("//button[contains(@class, 'btn-primary')]").click();
        $$x("//li[@gridster-item='widget']").shouldHave(sizeGreaterThan(0), ofSeconds(20));

    }

}