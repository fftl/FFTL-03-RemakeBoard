package fftl.fftl03RemakeBoard.request;

import fftl.fftl03RemakeBoard.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor /** Cannot construct instance of~ error를 해결해주었다. * */
public class SaveUserDto {

    private String username;
    private String password;
    private String nickname;

    private String userRegdate;
    private String role = "USER";

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .userRegdate(userRegdate)
                .build();
    }
}
