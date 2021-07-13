package fftl.fftl03RemakeBoard.entity;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Board {

    private int boardId;
    private String title;
    private String content;
    private String nickname;
    private String boardRegdate;

    private int userId;
}
