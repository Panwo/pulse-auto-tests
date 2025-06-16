package pages.commonelements.headersdropdown;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ManagementDropdown {

    private SelenideElement dropdownContainer(){
        return $("ul[class*='dropdown-menu-right show']");
    }

    public SelenideElement dashboardManagement() {
        return dropdownContainer().$(byText("Dashboard Management"));
    }

    public SelenideElement wallboardManagement() {
        return dropdownContainer().$(byText("Wallboard Management"));
    }

    public SelenideElement widgetManagement() {
        return dropdownContainer().$(byText("Widget Management"));
    }

    public SelenideElement widgetTemplateManagement() {
        return dropdownContainer().$(byText("Widget Template Management"));
    }

    public SelenideElement importExportOptions() {
        return dropdownContainer().$(byText("Import/Export Options"));
    }

    public SelenideElement preferences() {
        return dropdownContainer().$(byText("Preferences"));
    }

}