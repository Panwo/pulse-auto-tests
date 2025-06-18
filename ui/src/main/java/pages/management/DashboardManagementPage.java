package pages.management;

import com.codeborne.selenide.SelenideElement;

public class DashboardManagementPage extends AbstractManagementPage {

    public SelenideElement moveButton(){
        return toolbarContainer().$("button[title='Move']");
    }

    public SelenideElement openDashboardButton(){
        return entityManagementContainer().$("button[title='Open']");
    }

    public SelenideElement cloneDashboardButton(){
        return entityManagementContainer().$("button[title='Clone a Dashboard']");
    }

}