package com.example.splitwise.controllers;

import com.example.splitwise.dtos.RegisterUserRequestDto;
import com.example.splitwise.dtos.RegisterUserResponseDto;
import com.example.splitwise.dtos.UpdateProfileRequestDto;
import com.example.splitwise.dtos.UpdateProfileResponseDto;
import com.example.splitwise.models.User;
import com.example.splitwise.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // /users/get/{id} -> @PathVariable
    @PostMapping("/users/register")
    public RegisterUserResponseDto registerUser(@RequestBody RegisterUserRequestDto request) {
        User user = userService.registerUser(
                request.getPhoneNumber(),
                request.getPassword(),
                request.getUsername()
        );

        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUser(user);
        return registerUserResponseDto;
    }

    @PutMapping("/users/update")
    public UpdateProfileResponseDto updateProfile(@RequestBody UpdateProfileRequestDto request) {
        User user = userService.updateProfile(
                request.getUserId(),
                request.getNewPassword()
        );

        UpdateProfileResponseDto response = new UpdateProfileResponseDto();
        response.setUser(user);
        return response;
    }

}
