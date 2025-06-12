package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class NavigationBar {

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