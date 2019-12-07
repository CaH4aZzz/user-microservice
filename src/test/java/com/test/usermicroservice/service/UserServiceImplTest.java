package com.test.usermicroservice.service;

import com.test.usermicroservice.entity.User;
import com.test.usermicroservice.exception.NonExistingUserException;
import com.test.usermicroservice.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    private static User user_1;
    private static User user_2;
    private static User user_3;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);

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
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUserTest() {

        when(userRepository.findById(1)).thenReturn(Optional.of(user_1));
        assertEquals(user_1, userService.getUser(1));
    }

    @Test
    void getUserTest_withException() {
        int id = 1;

        when(userRepository.findById(id)).thenThrow(new NonExistingUserException("Could not find user_1 with ID = " + id));
    }

    @Test
    void getAllUsersTest() {

        List<User> users = Arrays.asList(user_1, user_2, user_3);

        when(userRepository.findAll()).thenReturn(users);

        assertEquals(users.size(), userService.getAllUsers().size());
        assertEquals(users, userService.getAllUsers());
    }

    @Test
    void getAllUsersTest_empty() {
        List<User> users = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(users);

        assertEquals(users.size(), userService.getAllUsers().size());
        assertEquals(users, userService.getAllUsers());
    }

    @Test
    void getAllUsersTest_oneRecord() {
        List<User> users = Collections.singletonList(user_1);
        when(userRepository.findAll()).thenReturn(users);

        assertEquals(users.size(), userService.getAllUsers().size());
        assertEquals(users, userService.getAllUsers());
    }
}