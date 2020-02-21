package com.spintech.testtask.service;

import com.spintech.testtask.entity.User;

import java.util.Optional;

public interface UserService {

    User registerUser(String email, String password);

    User findUser(String email, String password);

    Optional<User> findById(Long aLong);

    User findByEmail(String email);

    User updateUser(User user);
}

