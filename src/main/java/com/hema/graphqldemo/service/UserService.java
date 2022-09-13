package com.hema.graphqldemo.service;

import com.hema.graphqldemo.entity.User;

public interface UserService {
    User getUserById(Long id);
    User createUser(String name, String organization, String email);
}
