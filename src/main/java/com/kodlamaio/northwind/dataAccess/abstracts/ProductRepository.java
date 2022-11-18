package com.kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByName(String name);

}
