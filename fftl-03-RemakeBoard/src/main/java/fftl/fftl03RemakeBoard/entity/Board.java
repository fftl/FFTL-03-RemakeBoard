package fftl.fftl03RemakeBoard.entity;

import fftl.fftl03RemakeBoard.request.SaveBoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String nickname;
    @Column
    private String boardRegdate;

    @Column
    private Long userId;

    public void updateBoard(SaveBoardDto saveBoardDto){
        this.title = saveBoardDto.getTitle();
        this.content = saveBoardDto.getContent();
        this.nickname = saveBoardDto.getNickname();
    }
}
