package pages.management;

import com.codeborne.selenide.SelenideElement;

public class WidgetManagementPage extends AbstractManagementPage {

    public SelenideElement activateWidgetsButton(){
        return toolbarContainer().$("button[title='Activate Widget(s)']");
    }

    public SelenideElement deactivateWidgetsButton(){
        return toolbarContainer().$("button[title='Deactivate Widget(s)']");
    }

    public SelenideElement editWidgetButton(){
        return entityManagementContainer().$("button[title='Edit']");
    }

    public SelenideElement deactivateWidgetButton(){
        return entityManagementContainer().$("button[title='Deactivate']");
    }

}