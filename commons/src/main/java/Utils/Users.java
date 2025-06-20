package Utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Users {

    public static UserCredentialsDto getDefaultUser() {
        return UserCredentialsDto.builder()
                .userName(System.getenv("PulseUser"))
                .password(System.getenv("PulsePassword"))
                .build();
    }

}