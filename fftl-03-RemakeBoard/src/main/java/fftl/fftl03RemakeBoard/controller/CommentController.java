package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
}
