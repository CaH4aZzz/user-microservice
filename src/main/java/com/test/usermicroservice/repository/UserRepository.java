package com.test.usermicroservice.repository;

import com.test.usermicroservice.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
