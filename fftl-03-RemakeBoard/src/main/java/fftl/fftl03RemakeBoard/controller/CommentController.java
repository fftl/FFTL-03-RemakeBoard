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

    @PostMapping(value="")
    public Comment saveComment(@RequestBody SaveCommentDto saveCommentDto){
        Comment comment = commentService.saveComment(saveCommentDto);

        return comment;
    }

    @GetMapping(value="/{boardId}")
    public List<Comment> findAllBoard(@PathVariable Long boardId){
        List<Comment> comments = commentService.findAllComment(boardId);

        return comments;
    }

    @PatchMapping(value="/{commentId}")
    public String updateComment(@PathVariable Long commentId, @RequestBody SaveCommentDto saveCommentDto){
        Comment comment = commentService.findByCommentId(commentId);
        commentService.updateComment(comment, saveCommentDto);

        return "success!";
    }

    @DeleteMapping(value="/{commentId}")
    public String deleteBoard(@PathVariable Long commentId){
        Comment comment = commentService.findByCommentId(commentId);
        commentService.deleteComment(comment);

        return "success!";
    }

}
