package fftl.fftl03RemakeBoard.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @Column
    private String nickname;
    @Column
    private String content;
    @Column
    private String commentRegdate;

    @Column
    private int boardId;
    @Column
    private int userId;
}
