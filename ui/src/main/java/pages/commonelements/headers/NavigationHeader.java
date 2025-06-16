package pages.commonelements.headers;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import pages.commonelements.headersdropdown.ManagementDropdown;
import pages.commonelements.headersdropdown.UserPreferencesDropdown;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class NavigationHeader {

    private final UserPreferencesDropdown userPreferencesDropdown = new UserPreferencesDropdown();
    private final ManagementDropdown managementDropdown = new ManagementDropdown();
    public static final String PULSE_BRAND_TEXT = "Pulse";

    public SelenideElement navigationBar(){
        return $("nav.navigation-bar");
    }

    public SelenideElement navigationBarBrand(){
        return navigationBar().$("a.navigation-bar-brand");
    }

    public SelenideElement navigationBarUserDropdown(){
        return navigationBar().$("a[class*='user-name-menu']");
    }

}