package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.request.SaveBoardDto;
import fftl.fftl03RemakeBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/board")
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping(value="")
    public String saveBoard(@RequestBody SaveBoardDto saveBoardDto){
        Long boardId = boardService.saveBoard(saveBoardDto);

        return boardId.toString();
    }

    @GetMapping(value="/{boardId}")
    public String
}
