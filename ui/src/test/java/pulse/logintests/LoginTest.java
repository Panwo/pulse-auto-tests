package pulse.logintests;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.commonelements.headers.NavigationHeader;
import properies.CommonConfig;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;
import static pages.commonelements.headers.NavigationHeader.PULSE_BRAND_TEXT;


@Tag("smokeUI")
class LoginTest {

    public static final CommonConfig config = create(CommonConfig.class, getProperties());
    private final LoginPage loginPage = new LoginPage();
    private final NavigationHeader navigationHeader = new NavigationHeader();

    @Test
    void shouldBeAbleToLogin() {
        open(config.baseUrl());
        loginPage.loginAsDefault();
        navigationHeader.navigationBarUserDropdown().shouldHave(partialText("default default"));
        navigationHeader.navigationBarBrand().shouldHave(text(PULSE_BRAND_TEXT));
    }

}