package com.test.usermicroservice.repository;

import com.test.usermicroservice.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> getUserByUsername(String username);
}
