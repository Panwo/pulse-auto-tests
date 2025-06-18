package pages.management;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class AbstractManagementPage {

    private SelenideElement searchContainer() {
        return $(".filter-container");
    }

    protected SelenideElement toolbarContainer() {
        return $$(".grid-toolbar-main").find(visible);
    }

    protected SelenideElement entityManagementContainer(){
        return $$(".pulse-manage-entity-list-details").find(visible);
    }

    protected SelenideElement searchField() {
        return searchContainer().$(".input-container > input");
    }

    protected SelenideElement searchParameterButton() {
        return searchContainer().$("grid-container");
    }

    protected SelenideElement searchByColumnOption() {
        return $(".grid-menu > ul[class*= 'grid-dropdown-menu dropdown-menu']");
    }

    protected SelenideElement gridContainer() {
        return $$("div[class*='ag-root ag-unselectable']").find(visible);
    }

    protected SelenideElement detailsContainer() {
        return $$(".pulse-manage-entity-list-details").find(visible);
    }

    public SelenideElement deleteButton() {
        return toolbarContainer().$("button[title*='Delete']");
    }

    public SelenideElement refreshButton() {
        return toolbarContainer().$("button[title='Refresh']");
    }
    public SelenideElement exportButton(){
       return toolbarContainer().$("button[title*='Export']");
    }

    public SelenideElement deleteEntityButton(){
        return entityManagementContainer().$("button[title*='Delete']");
    }

}