package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.entity.Board;
import fftl.fftl03RemakeBoard.request.SaveBoardDto;
import fftl.fftl03RemakeBoard.response.DefaultResponse;
import fftl.fftl03RemakeBoard.response.ResponseMessage;
import fftl.fftl03RemakeBoard.response.StatusCode;
import fftl.fftl03RemakeBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    /** 게시글 작성 입니다. */
    @PostMapping(value="")
    public ResponseEntity saveBoard(@RequestBody SaveBoardDto saveBoardDto){
        Long boardId = boardService.saveBoard(saveBoardDto);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.CREATED_USER), HttpStatus.OK);
    }

    /** 게시글 조회 입니다. */
    @GetMapping(value="/{boardId}")
    public ResponseEntity findOneBoard(@PathVariable Long boardId){
        Board board = boardService.findByBoardId(boardId);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.GET_ONE_BOARD, board), HttpStatus.OK);
    }

    /** 게시글 전체 조회 입니다. */
    @GetMapping(value="")
    public ResponseEntity findAllBoard(){
        List<Board> boards = boardService.findAllBoard();

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.GET_ALL_BOARD, boards), HttpStatus.OK);
    }

    /** 게시글 수정 입니다. */
    @PatchMapping(value="/{boardId}")
    public ResponseEntity updateBoard(@PathVariable Long boardId, @RequestBody SaveBoardDto saveBoardDto){
        Board board = boardService.findByBoardId(boardId);
        Board updatedBoard = boardService.updateBoard(board, saveBoardDto);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.UPDATE_BOARD, updatedBoard), HttpStatus.OK);
    }

    /** 게시글 삭제 입니다. */
    @DeleteMapping(value="/{boardId}")
    public ResponseEntity deleteBoard(@PathVariable Long boardId){
        Board board = boardService.findByBoardId(boardId);
        boardService.deleteBoard(board);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.DELETE_BOARD), HttpStatus.OK);
    }
}
