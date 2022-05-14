package com.example.springbootdenispronin.dao;


import com.example.springbootdenispronin.model.Role;

import java.util.List;

public interface RoleDao {
    Role getRoleByName(String name);
    List<Role> getListRole();
}
