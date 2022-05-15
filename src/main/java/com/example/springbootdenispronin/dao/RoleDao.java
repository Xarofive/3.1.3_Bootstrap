package com.example.springbootdenispronin.dao;


import com.example.springbootdenispronin.model.Role;

import java.util.Set;

public interface RoleDao {
    Role getRoleByName(String name);
    Set<Role> findRolesById(Long[] ids);
}
