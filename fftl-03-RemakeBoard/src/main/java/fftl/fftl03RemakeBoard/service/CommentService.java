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

    public Comment saveComment(SaveCommentDto saveCommentDto){
        Comment comment = commentRepository.save(saveCommentDto.toEntity());

        return comment;
    }

    public Comment findByCommentId(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        return comment;
    }

    public List<Comment> findAllComment(Long boardId){
        List<Comment> comments = commentRepository.findByBoardId(boardId);

        return comments;
    }

    public void deleteComment(Comment comment){
        commentRepository.delete(comment);
    }

    public void updateComment(Comment comment, SaveCommentDto saveCommentDto){
        comment.updateContent(saveCommentDto);
    }
}
