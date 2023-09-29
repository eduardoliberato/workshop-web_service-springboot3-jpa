package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController //This tells Spring that this code describes an endpoint that should be made available over the web 
@RequestMapping(value = "/users")// tells Spring to use our findAll() method to answer requests that get sent to the http://localhost:8080/users address
public class UserResource {
	
	//use the class "User" as the type 
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@maira", "999999999", "12345");
		return ResponseEntity.ok().body(u);
}
}
