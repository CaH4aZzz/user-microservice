package com.test.usermicroservice.service;

import com.test.usermicroservice.entity.User;
import com.test.usermicroservice.exception.NonExistingUserException;
import com.test.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(int id)
            throws NoSuchElementException {
        return userRepository.findById(id).orElseThrow(() -> new NonExistingUserException("Could not find user with ID = " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
