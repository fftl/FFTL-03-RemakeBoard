package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;
}
