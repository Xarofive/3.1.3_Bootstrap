package com.example.springbootdenispronin.dao;

import com.example.springbootdenispronin.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("select role from  Role role where role.role =: name", Role.class)
                .setParameter("name",name)
                .getSingleResult();
    }

    @Override
    public Set<Role> findRolesById(Long[] ids) {
        return entityManager
                .createQuery("select r from Role r where r.id in (:ids)", Role.class)
                .setParameter("ids", Arrays.asList(ids))
                .getResultStream()
                .collect(Collectors.toSet());
    }
}
