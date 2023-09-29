package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//is not necessary to implement the interface, because the JpaRepository already has a standard implementation
	//This UserRepository can access the database, this is his function 

}
