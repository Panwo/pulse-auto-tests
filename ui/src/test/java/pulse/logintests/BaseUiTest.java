package pulse.logintests;


import Utils.test.UserCredentialsDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.commonelements.headers.NavigationHeader;
import properies.CommonConfig;

import static Utils.test.CredentialUtils.loginAs;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static java.lang.System.getenv;
import static org.aeonbits.owner.ConfigFactory.create;
import static utils.SessionUtility.*;

public class BaseUiTest {

    protected static final NavigationHeader navigationHeader = new NavigationHeader();
    public static final CommonConfig config = create(CommonConfig.class, getProperties());
    private static final UserCredentialsDto credentials = UserCredentialsDto.builder()
            .userName(getenv("PulseUser"))
            .password(getenv("PulsePassword"))
            .build();

    @BeforeAll
    public static void setUp() {
        var cookie = loginAs(credentials).getCookie("JSESSIONID");
        openPageWithCookies(config.baseUrl(), cookie);
    }

    @BeforeEach
    public void openPage(){
        open(config.baseUrl());
    }

}