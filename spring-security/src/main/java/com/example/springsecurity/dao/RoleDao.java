package com.example.springsecurity.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String>{

}
