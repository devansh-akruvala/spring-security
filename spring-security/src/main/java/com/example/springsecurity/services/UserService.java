package com.example.springsecurity.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.dao.RoleDao;
import com.example.springsecurity.dao.UserDao;
import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registerNewUser(User user) {
		return userDao.save(user);
	}
	
	public void initRolesAndUsers() {
		
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin of App");
		roleDao.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Normal User");
		roleDao.save(userRole);
		
		User adminUser=new User();
		adminUser.setUserName("admin_ADM");
		adminUser.setFirstName("admin");
		adminUser.setLastName("admin");
		adminUser.setPassword(getEncodedPassword("admin"));
		Set<Role> adminRoles = new HashSet<Role>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);
		
		User normalUser=new User();
		normalUser.setUserName("devansh_123");
		normalUser.setFirstName("devansh");
		normalUser.setLastName("akruvala");
		normalUser.setPassword(getEncodedPassword("devansh@123"));
		Set<Role> userRoles = new HashSet<Role>();
		userRoles.add(userRole);
		normalUser.setRole(userRoles);
		userDao.save(normalUser);
		
		
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
