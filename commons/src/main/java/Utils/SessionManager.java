package Utils;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static Utils.CredentialUtils.*;
import static Utils.Users.*;

@UtilityClass
public class SessionManager {

    private final Map<String, String> sessionCache = new ConcurrentHashMap<>();

    public String getSessionId(UserCredentialsDto user) {
        return sessionCache.computeIfAbsent(user.getUserName(), u -> loginAndGetSessionId(user));
    }

    public String getDefaultSessionId() {
        return getSessionId(getDefaultUser());
    }

    private String loginAndGetSessionId(UserCredentialsDto user) {
        return loginAs(user).getCookie("JSESSIONID");
    }

}