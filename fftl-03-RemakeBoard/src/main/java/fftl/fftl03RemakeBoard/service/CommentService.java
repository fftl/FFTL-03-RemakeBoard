package fftl.fftl03RemakeBoard.service;

import fftl.fftl03RemakeBoard.entity.Comment;
import fftl.fftl03RemakeBoard.repository.CommentRepository;
import fftl.fftl03RemakeBoard.request.SaveCommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    /** 댓글을 생성하는 saveComment 입니다. */
    public Comment saveComment(SaveCommentDto saveCommentDto){
        Comment comment = commentRepository.save(saveCommentDto.toEntity());

        return comment;
    }

    /** 댓글 하나를 조회하는 findByCommentId 입니다. (사용할 데가 없으려나..)*/
    public Comment findByCommentId(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        return comment;
    }

    /** boardId(pk) 게시글 아이디에 연관된 모든 댓글을 가져오는 findAllComment 입니다. */
    public List<Comment> findAllComment(Long boardId){
        List<Comment> comments = commentRepository.findByBoardId(boardId);

        return comments;
    }

    /** 댓글 수정할 수 있는 updateComment 입니다. */
    public void updateComment(Comment comment, SaveCommentDto saveCommentDto){
        comment.updateContent(saveCommentDto);
    }

    /** 댓글을 삭제할 수 있는 deleteComment 입니다. */
    public void deleteComment(Comment comment){
        commentRepository.delete(comment);
    }
}
