package pulse.logintests;


import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;

class LogoutTests extends BaseUiTest {

    private final LoginPage loginPage = new LoginPage();

    @Test
    void shouldBeAbleToLogOut() {
        navigationHeader.navigationBarUserDropdown().shouldBe(visible).click();
        navigationHeader.getUserPreferencesDropdown().logOut().shouldBe(visible).click();
        loginPage.passwordField().shouldBe(visible);
    }

}
