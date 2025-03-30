package com.example.Eyada.Services;

import com.example.Eyada.Models.DTOs.UserDto;
import com.example.Eyada.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

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
}
