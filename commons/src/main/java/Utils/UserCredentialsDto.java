package Utils;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialsDto {

    private String userName;
    @ToString.Exclude
    private String password;

}