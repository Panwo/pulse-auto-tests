package pages.management;

import com.codeborne.selenide.SelenideElement;

public class WallboardManagementPage extends AbstractManagementPage {

    public SelenideElement moveButton(){
        return toolbarContainer().$("button[title='Move']");
    }

    public SelenideElement openWallboardButton(){
        return entityManagementContainer().$("button[title='Open']");
    }

    public SelenideElement cloneWallboardButton(){
        return entityManagementContainer().$("button[title='Clone a Wallboard']");
    }

}