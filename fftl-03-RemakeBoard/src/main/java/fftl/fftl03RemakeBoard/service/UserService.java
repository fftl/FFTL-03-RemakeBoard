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

    public User saveUser(SaveUserDto saveUserDto){
        User user = userRepository.save(saveUserDto.toEntity());
        return user;
    }

    public User findByUsername(String username){
        User user = userRepository.findByUsername(username);
        return user;
    }

    public User findByUserId(Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        return user;
    }

    public User updateUser(User user, SaveUserDto saveUserDto){
        user.updateUser(saveUserDto);
        return user;
    }

    public boolean deleteUser(User user){
        userRepository.delete(user);
        return true;
    }
}
