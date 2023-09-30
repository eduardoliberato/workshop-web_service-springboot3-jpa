package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service //to register a service, as a component of the spring
public class OrderService {
	
	@Autowired
	private OrderRepository repository; //to create dependency
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); //will return a obj of the type Order, that be inside the optional
}
}
