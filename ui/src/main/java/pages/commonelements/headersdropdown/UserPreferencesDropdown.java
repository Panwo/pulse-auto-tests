package pages.commonelements.headersdropdown;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserPreferencesDropdown {

    private SelenideElement dropdownContainer(){
        return $("ul[class*='dropdown-menu-right show']");
    }

    public SelenideElement preferences(){
        return dropdownContainer().$(byText("Preferences"));
    }

    public SelenideElement about(){
        return dropdownContainer().$(byText("About"));
    }

    public SelenideElement logOut(){
        return dropdownContainer().$(byText("Log Out"));
    }

}