package com.advantum.barcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advantum.barcode.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
