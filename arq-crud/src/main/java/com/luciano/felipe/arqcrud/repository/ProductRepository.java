package com.luciano.felipe.arqcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciano.felipe.arqcrud.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
