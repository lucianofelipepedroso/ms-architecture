package com.luciano.felipe.arqpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciano.felipe.arqpayment.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
