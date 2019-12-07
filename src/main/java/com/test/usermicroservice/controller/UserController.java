package com.test.usermicroservice.controller;

import com.test.usermicroservice.dto.UserDTO;
import com.test.usermicroservice.entity.User;
import com.test.usermicroservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/users")
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping ("/{id}")
    @ResponseBody
    public UserDTO getUser(@PathVariable int id) {

        return convertToDto(userService.getUser(id));
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {

        return userService.getAllUsers().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
