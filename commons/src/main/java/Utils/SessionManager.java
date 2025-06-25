package Utils;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static Utils.AuthClient.*;

@UtilityClass
public class SessionManager {

    private final Map<String, String> sessionCache = new ConcurrentHashMap<>();

    public String getSessionId(UserCredentialsDto user) {
        return sessionCache.computeIfAbsent(user.getUserName(), u -> loginAndGetSessionId(user));
    }

    private String loginAndGetSessionId(UserCredentialsDto user) {
        return loginAs(user).getCookie("JSESSIONID");
    }

}