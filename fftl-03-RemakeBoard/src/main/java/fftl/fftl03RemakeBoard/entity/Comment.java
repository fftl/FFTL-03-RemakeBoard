package fftl.fftl03RemakeBoard.entity;

import fftl.fftl03RemakeBoard.request.SaveCommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
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
    private Long boardId;
    @Column
    private Long userId;

    public void updateContent(SaveCommentDto saveCommentDto){
        this.content = saveCommentDto.getContent();
    }
}
