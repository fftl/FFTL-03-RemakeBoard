package fftl.fftl03RemakeBoard.entity;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Comment {

    private int commentId;
    private String nickname;
    private String content;
    private String commentRegdate;

    private int boardId;
    private int userId;
}
