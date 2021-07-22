package fftl.fftl03RemakeBoard.request;

import fftl.fftl03RemakeBoard.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommentDto {

    private String nickname;
    private String content;
    private String commentRegdate;
    private Long boardId;
    private Long userId;

    public Comment toEntity(){
        return Comment.builder()
                .nickname(nickname)
                .content(content)
                .commentRegdate(commentRegdate)
                .boardId(boardId)
                .userId(userId)
                .build();
    }
}
