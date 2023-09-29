package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController //This tells Spring that this code describes an endpoint that should be made available over the web 
@RequestMapping(value = "/users/")// tells Spring to use our findAll() method to answer requests that get sent to the http://localhost:8080/users address
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	//use the class "User" as the type 
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ResponseEntity.ok() = response of success of the http , body of the answer (the content) 
}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
