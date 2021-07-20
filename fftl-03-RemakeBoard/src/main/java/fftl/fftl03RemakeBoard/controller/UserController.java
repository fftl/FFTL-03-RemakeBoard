package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
}
