package com.devotel.userservice.service.Impl;

import com.devotel.userservice.domain.User;
import com.devotel.userservice.dto.UserRequestDto;
import com.devotel.userservice.dto.UserResponseDto;
import com.devotel.userservice.exception.UserNotFoundException;
import com.devotel.userservice.repository.UserRepository;
import com.devotel.userservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        User user = objectMapper.convertValue(dto, User.class);
        user = userRepository.save(user);
        return objectMapper.convertValue(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found" + id));
        return objectMapper.convertValue(user, UserResponseDto.class);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> objectMapper.convertValue(user, UserResponseDto.class))
                .toList();
    }

}
