package com.example.springbootdenispronin.service;

import com.example.springbootdenispronin.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void create(User user);

    void update(User user);

    User get(Long id);

    void delete(Long id);

    User showByName(String name);
}
