package pages.management;

import com.codeborne.selenide.SelenideElement;

public class WidgetTemplatesManagementPage extends AbstractManagementPage {

    public SelenideElement createTemplateButton() {
        return toolbarContainer().$("button[title=''New Template]");
    }

    public SelenideElement moveButton(){
        return toolbarContainer().$("button[title='Move']");
    }

    public SelenideElement editTemplateButton(){
       return entityManagementContainer().$("button[title='Edit a Template']");
    }

    public SelenideElement cloneTemplateButton(){
        return entityManagementContainer().$("button[title='Clone a Template']");
    }

}