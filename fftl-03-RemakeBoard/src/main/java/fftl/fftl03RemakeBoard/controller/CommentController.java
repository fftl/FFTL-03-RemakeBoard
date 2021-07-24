package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.entity.Comment;
import fftl.fftl03RemakeBoard.request.SaveCommentDto;
import fftl.fftl03RemakeBoard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    /** 댓글 입력 입니다. */
    @PostMapping(value="")
    public Comment saveComment(@RequestBody SaveCommentDto saveCommentDto){
        Comment comment = commentService.saveComment(saveCommentDto);

        return comment;
    }

    /** 댓글 전체조회(게시글 기준) 입니다. */
    @GetMapping(value="/{boardId}")
    public List<Comment> findAllBoard(@PathVariable Long boardId){
        List<Comment> comments = commentService.findAllComment(boardId);

        return comments;
    }

    /** 댓글 수정 입니다. */
    @PatchMapping(value="/{commentId}")
    public String updateComment(@PathVariable Long commentId, @RequestBody SaveCommentDto saveCommentDto){
        Comment comment = commentService.findByCommentId(commentId);
        commentService.updateComment(comment, saveCommentDto);

        return "success!";
    }

    /** 댓글 삭제 입니다. */
    @DeleteMapping(value="/{commentId}")
    public String deleteBoard(@PathVariable Long commentId){
        Comment comment = commentService.findByCommentId(commentId);
        commentService.deleteComment(comment);

        return "success!";
    }
}
