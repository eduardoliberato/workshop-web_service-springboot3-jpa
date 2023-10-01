package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service //to register a service, as a component of the spring
public class ProductService {
	
	@Autowired
	private ProductRepository repository; //to create dependency
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get(); //will return a obj of the type Product, that be inside the optional
}
}
