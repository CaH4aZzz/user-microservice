package com.test.usermicroservice.service;

import com.test.usermicroservice.entity.User;

import java.util.List;

public interface UserService {

    User getUser(int id);

    List<User> getAllUsers();
}
