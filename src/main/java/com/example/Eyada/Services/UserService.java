package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.UserDto;
import com.example.Eyada.Models.Entities.User;
import com.example.Eyada.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto addUser(UserDto userDto){
        User user = User.fromDto(userDto);
        User savedUser = userRepository.save(user);
        return new UserDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
    }

    public Optional<UserDto> findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(user -> new
                        UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole()
                        )
                );
    }

    public UserDto updateUser(UserDto userDto){
        User user = User.fromDto(userDto);
        user.setId(userDto.getId());
        User savedUser = userRepository.save(user);
        return new UserDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getPassword(),
                savedUser.getRole()
        );
    }

    public Boolean deleteUser(Long userId){
        if(userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
