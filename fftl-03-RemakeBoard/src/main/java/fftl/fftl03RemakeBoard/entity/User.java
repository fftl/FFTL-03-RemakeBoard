package fftl.fftl03RemakeBoard.entity;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class User {

    private int userId;
    private String username;
    private String password;
    private String nickname;
    private String userRegdate;
}
