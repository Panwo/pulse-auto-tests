package pages.management;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class BaseManagementPage {

    private SelenideElement searchContainer() {
        return $(".filter-container");
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
        return $$("").find(visible);

    }

    public SelenideElement refreshButton() {
        return $$("button[title='Refresh']").find(visible);
    }

}