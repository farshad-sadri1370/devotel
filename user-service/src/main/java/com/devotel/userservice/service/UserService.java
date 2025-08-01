package com.devotel.userservice.service;

import com.devotel.userservice.dto.UserRequestDto;
import com.devotel.userservice.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();
}
