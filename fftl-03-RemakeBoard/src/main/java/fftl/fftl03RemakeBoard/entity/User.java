package fftl.fftl03RemakeBoard.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
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

}
