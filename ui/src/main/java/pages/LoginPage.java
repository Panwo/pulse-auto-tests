package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.System.*;

public class LoginPage {

    public SelenideElement userNameField(){
        return $("input[class*='ark-login-username']");
    }

    public SelenideElement passwordField(){
        return $("input[class*='ark-login-password'");
    }

    public SelenideElement logInButton(){
        return $("div.ark-login-button");
    }

    public void fillUsername(String username){
        userNameField().sendKeys(username);
    }

    public void fillPassword(String password){
        passwordField().sendKeys(password);
    }

    public void loginAsDefault (){
        fillUsername(getenv("PulseUser"));
        fillPassword(getenv("PulsePassword"));
        logInButton().click();
    }

}