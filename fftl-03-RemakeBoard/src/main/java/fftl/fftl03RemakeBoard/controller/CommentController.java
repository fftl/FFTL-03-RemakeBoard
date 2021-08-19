package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.entity.Comment;
import fftl.fftl03RemakeBoard.request.SaveCommentDto;
import fftl.fftl03RemakeBoard.response.DefaultResponse;
import fftl.fftl03RemakeBoard.response.ResponseMessage;
import fftl.fftl03RemakeBoard.response.StatusCode;
import fftl.fftl03RemakeBoard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    /** 댓글 입력 입니다. */
    @PostMapping(value="")
    public ResponseEntity saveComment(@RequestBody SaveCommentDto saveCommentDto){
        Comment comment = commentService.saveComment(saveCommentDto);

        return new ResponseEntity(DefaultResponse.response(StatusCode.CREATED, ResponseMessage.CREATED_COMMENT), HttpStatus.OK);
    }

    /** 댓글 전체조회(게시글 기준) 입니다. */
    @GetMapping(value="/{boardId}")
    public ResponseEntity findAllBoard(@PathVariable Long boardId){
        List<Comment> comments = commentService.findAllComment(boardId);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.GET_ALL_COMMENT), HttpStatus.OK);
    }

    /** 댓글 수정 입니다. */
    @PatchMapping(value="/{commentId}")
    public ResponseEntity updateComment(@PathVariable Long commentId, @RequestBody SaveCommentDto saveCommentDto){
        Comment comment = commentService.findByCommentId(commentId);
        commentService.updateComment(comment, saveCommentDto);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.UPDATE_COMMENT), HttpStatus.OK);
    }

    /** 댓글 삭제 입니다. */
    @DeleteMapping(value="/{commentId}")
    public ResponseEntity deleteBoard(@PathVariable Long commentId){
        Comment comment = commentService.findByCommentId(commentId);
        commentService.deleteComment(comment);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.DELETE_COMMENT), HttpStatus.OK);
    }
}
