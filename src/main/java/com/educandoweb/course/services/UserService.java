package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service //to register a service, as a component of the spring
public class UserService {
	
	@Autowired
	private UserRepository repository; //to create dependency
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); //will return a obj of the type User, that be inside the optional
}
	
	//to save in the database a new user
	public User insert(User obj) {
		return repository.save(obj);
		
	}
	
}
