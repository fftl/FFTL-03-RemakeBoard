package fftl.fftl03RemakeBoard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Getter
@NoArgsConstructor /** @Builder와 @NoArgsConstructor 두 개만을 같이 사용할 수 없다. @AllArgsConstructor 를 추가해야 한다. */
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String nickname;
    @Column
    private String userRegdate;
    @Column
    private String role;

}
