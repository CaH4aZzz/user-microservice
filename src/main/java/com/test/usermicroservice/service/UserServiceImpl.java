package com.test.usermicroservice.service;

import com.test.usermicroservice.entity.User;
import com.test.usermicroservice.exception.NonExistingUserException;
import com.test.usermicroservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(int id)
            throws NonExistingUserException {
        return userRepository.findById(id).orElseThrow(() -> new NonExistingUserException("Could not find user with ID = " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserByUserName(String username)
            throws NonExistingUserException {
        return userRepository.getUserByUsername(username).orElseThrow(() -> new NonExistingUserException("Could not find user with username = " + username));

    }


}
