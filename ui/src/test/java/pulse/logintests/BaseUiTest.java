package pulse.logintests;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.commonelements.headers.NavigationHeader;
import properies.CommonConfig;

import static Utils.CredentialUtils.loginAs;
import static Utils.Users.getDefaultUser;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;
import static utils.SessionUtility.openPageWithCookies;

public class BaseUiTest {

    protected static final NavigationHeader navigationHeader = new NavigationHeader();
    public static final CommonConfig config = create(CommonConfig.class, getProperties());

    @BeforeAll
    public static void setUp() {
        var cookie = loginAs(getDefaultUser()).getCookie("JSESSIONID");
        openPageWithCookies(config.baseUrl(), cookie);
    }

    @BeforeEach
    public void openPage() {
        open(config.baseUrl());
    }

}