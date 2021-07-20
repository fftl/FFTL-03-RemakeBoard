package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.config.security.JwtTokenProvider;
import fftl.fftl03RemakeBoard.entity.User;
import fftl.fftl03RemakeBoard.request.LoginDto;
import fftl.fftl03RemakeBoard.service.UserService;
import fftl.fftl03RemakeBoard.request.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/user")
@RestController
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping(value="")
    public Long saveUser(@RequestBody SaveUserDto saveUserDto){
        User user = userService.saveUser(saveUserDto);
        return user.getUserId();
    }

    @PostMapping(value="/login")
    public String login(@RequestBody LoginDto loginDto){
        boolean check = false;
        String userToken = "Nothing Token";
        User user = userService.findByUsername(loginDto.getUsername());

        if(user.getUserId() > 0){
            if(user.getPassword().equals(loginDto.getPassword())){
                check = true;
            }
        }

        if(check){
            System.out.println("check true!!");
            userToken = jwtTokenProvider.createToken(user.getUsername(), user.getRole());
        }

        return userToken;
    }
}
