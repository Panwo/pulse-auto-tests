package pages.management;

import com.codeborne.selenide.SelenideElement;

public class ImportExportPage extends AbstractManagementPage
{
    public SelenideElement importButton(){
        return toolbarContainer().$("button[title='Import']");
    }

}