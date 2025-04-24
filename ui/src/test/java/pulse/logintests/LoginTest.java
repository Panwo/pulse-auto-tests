package pulse.logintests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.*;
import static org.openqa.selenium.By.*;


class LoginTest extends BaseUiTest{

    private final String LOGIN = "paramonov.vdp@gmail.com";
    private final String PASSWORD = "";

    @Test
    void register(){

        $x("//input[contains(@class,'ark-login-username')]").sendKeys("default");
        $x("//input[contains(@class, 'ark-login-password')]").sendKeys("password");
        $x("//button[contains(@class, 'btn-primary')]").click();
        $$x("//li[@gridster-item='widget']").shouldHave(sizeGreaterThan(0), ofSeconds(20));

    }

}