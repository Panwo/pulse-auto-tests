package pages.commonelements.headers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TabsHeader {

    public SelenideElement addNewTabButton(){
        return $(".tabs-bar-button-placeholder > button");
    }

    public ElementsCollection tabs(){
        return $$("ul[role=tablist] > li");
    }

}