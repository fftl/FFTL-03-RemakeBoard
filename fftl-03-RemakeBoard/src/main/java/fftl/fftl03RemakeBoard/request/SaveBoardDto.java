package fftl.fftl03RemakeBoard.request;

import fftl.fftl03RemakeBoard.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveBoardDto {

    private String title;
    private String content;
    private String nickname;
    private String boardRegdate;
    private Long userId;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .nickname(nickname)
                .boardRegdate(boardRegdate)
                .userId(userId)
                .build();
    }
}
