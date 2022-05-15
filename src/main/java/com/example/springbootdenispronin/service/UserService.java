package com.example.springbootdenispronin.service;

import com.example.springbootdenispronin.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void create(User user, Long[] roles);

    void update(User user, Long[] roles);

    User get(Long id);

    void delete(Long id);

    User showByName(String name);
}
