package utils;

import com.codeborne.selenide.WebDriverRunner;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;

@UtilityClass
public class SessionUtility {

    public void openPageWithCookies(String path, String cookies) {
        open(path);
        WebDriverRunner.getWebDriver()
                .manage()
                .addCookie(new Cookie("JSESSIONID", cookies));
    }

}