package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController //This tells Spring that this code describes an endpoint that should be made available over the web 
@RequestMapping(value = "/categories")// tells Spring to use our findAll() method to answer requests that get sent to the http://localhost:8080/category/ address
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	
	//use the class "Category" as the type 
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){ //this is an endpoint to get all the categories 
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ResponseEntity.ok() = response of success of the http , body of the answer (the content) 
}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){ //this is an endpoint to get the categories by ID 
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
