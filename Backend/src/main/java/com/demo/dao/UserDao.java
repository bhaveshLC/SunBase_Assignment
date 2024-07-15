package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.User;
import java.util.List;


public interface UserDao extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
