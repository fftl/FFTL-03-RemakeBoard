package fftl.fftl03RemakeBoard.service;

import fftl.fftl03RemakeBoard.entity.User;
import fftl.fftl03RemakeBoard.repository.UserRepository;
import fftl.fftl03RemakeBoard.request.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    /** 유저를 생성하는 saveUser 입니다. */
    public User saveUser(SaveUserDto saveUserDto){
        User user = userRepository.save(saveUserDto.toEntity());
        return user;
    }

    /** username(id)를 통해 회원정보를 찾아내는 findByUsername 입니다. */
    public User findByUsername(String username){
        User user = userRepository.findByUsername(username);
        return user;
    }

    /** userId(pk)를 통해 회원정보를 찾아내는 findByUserId 입니다. */
    public User findByUserId(Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        return user;
    }

    /** user 정보를 수정할 수 있는 updateUser 입니다. */
    public User updateUser(User user, SaveUserDto saveUserDto){
        user.updateUser(saveUserDto);
        return user;
    }

    /** user 정보를 삭제하는 deleteUser 입니다. */
    public boolean deleteUser(User user){
        userRepository.delete(user);
        return true;
    }
}
