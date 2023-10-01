package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//is not necessary to implement the interface, because the JpaRepository already has a standard implementation
	//This CategoryRepository can access the database, this is his function 

}
