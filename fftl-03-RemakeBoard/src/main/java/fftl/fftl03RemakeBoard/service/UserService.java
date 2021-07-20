package fftl.fftl03RemakeBoard.service;

import fftl.fftl03RemakeBoard.entity.User;
import fftl.fftl03RemakeBoard.repository.UserRepository;
import fftl.fftl03RemakeBoard.request.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
