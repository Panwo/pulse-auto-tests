package data.enums.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UsersApi {

    USERS("/wbrt/users"),
    USERS_GUID("/wbrt/users/%s"),
    USERS_GUID_BRIEF_DISABLED("/wbrt/users/%s?brief=false");

    private final String path;

}