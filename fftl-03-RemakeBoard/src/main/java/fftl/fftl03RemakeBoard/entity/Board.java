package fftl.fftl03RemakeBoard.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Board {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardId;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String nickname;
    @Column
    private String boardRegdate;

    @Column
    private int userId;
}
