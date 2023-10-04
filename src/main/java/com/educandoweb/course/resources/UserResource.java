package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController //This tells Spring that this code describes an endpoint that should be made available over the web 
@RequestMapping(value = "/users")// tells Spring to use our methods to answer requests that get sent to the http://localhost:8080/users/ address
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	//use the class "User" as the type 
	@GetMapping
	public ResponseEntity<List<User>> findAll(){ //to find all that is requested
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ResponseEntity.ok() = response of success of the http , body of the answer (the content) 
}
	
	@GetMapping(value = "/{id}") //to find by id 
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping //this receive a post method of the http
	public ResponseEntity<User> insert(@RequestBody User obj){ //this permits to receive a obj in JSON format 
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	/*is void because it do not return nothing
	 * code to delete a user 
	 * PathVariable to recognize the long id as a variable in the URL*/
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}") //to update a user
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj ){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
