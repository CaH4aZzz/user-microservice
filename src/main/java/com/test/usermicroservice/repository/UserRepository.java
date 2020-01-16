package com.test.usermicroservice.repository;

import com.test.usermicroservice.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> getUserByUsername(String username);
}
