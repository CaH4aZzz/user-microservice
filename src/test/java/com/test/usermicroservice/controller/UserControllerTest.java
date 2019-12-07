package com.test.usermicroservice.controller;

import com.test.usermicroservice.dto.UserDTO;
import com.test.usermicroservice.entity.User;
import com.test.usermicroservice.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserControllerTest {
    private static User user_1;
    private static User user_2;
    private static User user_3;

    private static UserDTO userDTO_1;
    private static UserDTO userDTO_2;
    private static UserDTO userDTO_3;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService, modelMapper);
    }

    @BeforeAll
    static void setUp() {

        user_1 = User.builder()
                .id(1)
                .name("Sasha")
                .age(22)
                .gender("male")
                .address("Tokyo")
                .build();

        user_2 = User.builder()
                .id(2)
                .name("Max")
                .age(33)
                .gender("male")
                .address("Kyiv")
                .build();

        user_3 = User.builder()
                .id(3)
                .name("Olga")
                .age(24)
                .gender("female")
                .address("London")
                .build();

        userDTO_1 = UserDTO.builder()
                .name("Sasha")
                .age(22)
                .gender("male")
                .address("Tokyo")
                .build();

        userDTO_2 = UserDTO.builder()
                .name("Max")
                .age(33)
                .gender("male")
                .address("Kyiv")
                .build();

        userDTO_3 = UserDTO.builder()
                .name("Olga")
                .age(24)
                .gender("female")
                .address("London")
                .build();

    }

    @Test
    void getUserTest() {
        int id = 1;
        when(userService.getUser(id)).thenReturn(user_1);
        assertEquals(userController.convertToDto(user_1), userController.getUser(id));
    }

    @Test
    void getAllUsersTest() {
        List<User> users = Arrays.asList(user_1, user_2, user_3);

        when(userService.getAllUsers()).thenReturn(users);
        when(modelMapper.map(user_1, UserDTO.class)).thenReturn(userDTO_1);
        when(modelMapper.map(user_2, UserDTO.class)).thenReturn(userDTO_2);
        when(modelMapper.map(user_3, UserDTO.class)).thenReturn(userDTO_3);

        List<UserDTO> expectedUsersDTO = users.stream()
                .map(user -> userController.convertToDto(user))
                .collect(Collectors.toList());

        List<UserDTO> actualUsersDTO = userController.getAllUsers();
        assertEquals(expectedUsersDTO.size(), actualUsersDTO.size());
        assertEquals(expectedUsersDTO, actualUsersDTO);
    }

    @Test
    void convertToDtoTest() {

        when(modelMapper.map(user_1, UserDTO.class)).thenReturn(userDTO_1);

        UserDTO actualUserDTO = userController.convertToDto(user_1);

        assertEquals(userDTO_1.getName(), actualUserDTO.getName());
        assertEquals(userDTO_1.getAge(), actualUserDTO.getAge());
        assertEquals(userDTO_1.getAddress(), actualUserDTO.getAddress());
        assertEquals(userDTO_1.getGender(), actualUserDTO.getGender());
    }
}