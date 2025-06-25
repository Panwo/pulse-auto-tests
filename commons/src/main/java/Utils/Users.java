package Utils;

import lombok.experimental.UtilityClass;

import static Utils.AuthClient.*;

@UtilityClass
public class Users {

    public static UserCredentialsDto getDefaultUser() {
        return UserCredentialsDto.builder()
                .userName(requireEnv("PulseUser"))
                .password(requireEnv("PulsePassword"))
                .build();
    }

}