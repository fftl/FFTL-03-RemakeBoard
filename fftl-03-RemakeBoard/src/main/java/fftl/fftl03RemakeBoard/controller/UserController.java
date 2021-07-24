package fftl.fftl03RemakeBoard.controller;

import fftl.fftl03RemakeBoard.config.security.JwtTokenProvider;
import fftl.fftl03RemakeBoard.entity.User;
import fftl.fftl03RemakeBoard.request.LoginDto;
import fftl.fftl03RemakeBoard.service.UserService;
import fftl.fftl03RemakeBoard.request.SaveUserDto;
import lombok.RequiredArgsConstructor;
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
    public String saveUser(@RequestBody SaveUserDto saveUserDto){
        User user = userService.saveUser(saveUserDto);
        return user.getUserId().toString();
    }

    /** 회원정보 조회 입니다. */
    @GetMapping(value="/{userId}")
    public String findUser(@PathVariable Long userId){
        User user = userService.findByUserId(userId);
        return user.toString();
    }

    /** 토큰을 이용한 조회 입니다. */
    @GetMapping(value="")
    public User getUser(HttpServletRequest req){
        String username = jwtTokenProvider.getUserName(jwtTokenProvider.resolveToken(req));
        User user = userService.findByUsername(username);

        return user;
    }

    /** 로그인 기능입니다. token을 반환해 줍니다. */
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
            userToken = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        }

        return userToken;
    }

    /** 회원정보 변경 입니다. */
    @PatchMapping(value="{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody SaveUserDto saveUserDto){
        User user = userService.findByUserId(userId);
        userService.updateUser(user, saveUserDto);

        return "update success";
    }

    /** 회원정보 삭제 입니다. */
    @DeleteMapping(value="{userId}")
    public String deleteUser(@PathVariable Long userId){
        User user = userService.findByUserId(userId);
        userService.deleteUser(user);

        return "delete success";
    }
}
