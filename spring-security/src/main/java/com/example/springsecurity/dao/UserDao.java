package com.example.springsecurity.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entity.User;

@Repository
public interface UserDao extends CrudRepository<User,String>{
	
}
