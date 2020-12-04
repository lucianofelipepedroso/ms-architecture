package com.luciano.felipe.arqoauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciano.felipe.arqoauth.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String userName);

}
