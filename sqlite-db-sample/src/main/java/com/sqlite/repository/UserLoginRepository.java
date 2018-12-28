package com.sqlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqlite.entities.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {
	
	public UserLogin findByIdAndEmail(Integer id, String email);

}
