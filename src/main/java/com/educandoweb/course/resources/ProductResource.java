package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController //This tells Spring that this code describes an endpoint that should be made available over the web 
@RequestMapping(value = "/products")// tells Spring to use our findAll() method to answer requests that get sent to the http://localhost:8080/users address
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	
	//use the class "Product" as the type 
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ResponseEntity.ok() = response of success of the http , body of the answer (the content) 
}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
