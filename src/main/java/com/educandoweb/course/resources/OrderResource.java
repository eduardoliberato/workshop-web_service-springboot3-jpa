package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController //This tells Spring that this code describes an end point that should be made available over the web 
@RequestMapping(value = "/orders/")// tells Spring to use our findAll() method to answer requests that get sent to the http://localhost:8080/users address
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	
	//use the class "Order" as the type 
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ResponseEntity.ok() = response of success of the http , body of the answer (the content) 
}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
