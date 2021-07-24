package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.entity.Board;
import fftl.fftl03RemakeBoard.request.SaveBoardDto;
import fftl.fftl03RemakeBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    /** 게시글 작성 입니다. */
    @PostMapping(value="")
    public String saveBoard(@RequestBody SaveBoardDto saveBoardDto){
        Long boardId = boardService.saveBoard(saveBoardDto);

        return boardId.toString();
    }

    /** 게시글 조회 입니다. */
    @GetMapping(value="/{boardId}")
    public String findOneBoard(@PathVariable Long boardId){
        Board board = boardService.findByBoardId(boardId);

        return board.toString();
    }

    /** 게시글 전체 조회 입니다. */
    @GetMapping(value="")
    public List<Board> findAllBoard(){
        List<Board> boards = boardService.findAllBoard();

        return boards;
    }

    /** 게시글 수정 입니다. */
    @PatchMapping(value="/{boardId}")
    public String updateBoard(@PathVariable Long boardId, @RequestBody SaveBoardDto saveBoardDto){
        Board board = boardService.findByBoardId(boardId);
        Board updatedBoard = boardService.updateBoard(board, saveBoardDto);

        return  updatedBoard.toString();
    }

    /** 게시글 삭제 입니다. */
    @DeleteMapping(value="/{boardId}")
    public String deleteBoard(@PathVariable Long boardId){
        Board board = boardService.findByBoardId(boardId);
        boardService.deleteBoard(board);

        return "success delete";
    }
}
