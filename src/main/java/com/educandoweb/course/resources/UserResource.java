package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController //is implemented by a rest controller 
@RequestMapping(value = "/users")
public class UserResource {
	
	//use the class "User" as the type 
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@maira", "999999999", "12345");
		return ResponseEntity.ok().body(u);
}
}
