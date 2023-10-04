package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service //to register a service, as a component of the spring
public class UserService {
	
	@Autowired
	private UserRepository repository; //to create dependency
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		//orElseThrow - tries to do the get, if there is no user he send one exception, in this case our custom exception 
}
	
	//to save in the database a new user
	public User insert(User obj) {
		return repository.save(obj);
		
	}
	
	//to delete in the database a user by the id
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	//to update the information of the user in the database
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}
