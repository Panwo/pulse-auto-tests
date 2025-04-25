package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

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

}