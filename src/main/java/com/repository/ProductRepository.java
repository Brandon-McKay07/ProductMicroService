package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
