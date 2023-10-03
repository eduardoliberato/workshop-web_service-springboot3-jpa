package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
	//is not necessary to implement the interface, because the JpaRepository already has a standard implementation
	//This UserRepository can access the database and save information there, this is his function 

}
