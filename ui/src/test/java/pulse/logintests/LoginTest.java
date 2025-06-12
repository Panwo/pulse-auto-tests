package pulse.logintests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NavigationBar;


import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.text;
import static pages.NavigationBar.PULSE_BRAND_TEXT;


@Slf4j
class LoginTest extends BaseUiTest {

    private final LoginPage loginPage = new LoginPage();
    private final NavigationBar navigationBar = new NavigationBar();

    @Test
    void shouldBeAbleToLogin() {
        loginPage.loginAsDefault();
        navigationBar.navigationBarUserDropdown().shouldHave(partialText("default default"));
        navigationBar.navigationBarBrand().shouldHave(text(PULSE_BRAND_TEXT));
    }

}