package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.config.security.JwtTokenProvider;
import fftl.fftl03RemakeBoard.entity.User;
import fftl.fftl03RemakeBoard.request.LoginDto;
import fftl.fftl03RemakeBoard.response.DefaultResponse;
import fftl.fftl03RemakeBoard.response.ResponseMessage;
import fftl.fftl03RemakeBoard.response.StatusCode;
import fftl.fftl03RemakeBoard.service.UserService;
import fftl.fftl03RemakeBoard.request.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping(value = "/user")
@RestController
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    /** 회원가입 입니다. */
    @PostMapping(value="")
    public ResponseEntity saveUser(@RequestBody SaveUserDto saveUserDto){
        User user = userService.saveUser(saveUserDto);
        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.CREATED_USER), HttpStatus.OK);
    }

    /** 회원정보 조회 입니다. */
    @GetMapping(value="/{userId}")
    public ResponseEntity findUser(@PathVariable Long userId){
        User user = userService.findByUserId(userId);
        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.READ_USER), HttpStatus.OK);
    }

    /** 토큰을 이용한 조회 입니다. */
    @GetMapping(value="")
    public ResponseEntity getUser(HttpServletRequest req){
        String username = jwtTokenProvider.getUserName(jwtTokenProvider.resolveToken(req));
        User user = userService.findByUsername(username);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.READ_USER), HttpStatus.OK);
    }

    /** 로그인 기능입니다. token을 반환해 줍니다. */
    @PostMapping(value="/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
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
            userToken = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        }

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, userToken), HttpStatus.OK);
    }

    /** 회원정보 변경 입니다. */
    @PatchMapping(value="{userId}")
    public ResponseEntity updateUser(@PathVariable Long userId, @RequestBody SaveUserDto saveUserDto){
        User user = userService.findByUserId(userId);
        userService.updateUser(user, saveUserDto);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.UPDATE_USER), HttpStatus.OK);
    }

    /** 회원정보 삭제 입니다. */
    @DeleteMapping(value="{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId){
        User user = userService.findByUserId(userId);
        userService.deleteUser(user);

        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.DELETE_USER), HttpStatus.OK);
    }
}
