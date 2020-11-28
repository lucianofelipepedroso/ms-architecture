package com.luciano.felipe.arqpayment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luciano.felipe.arqpayment.data.vo.SaleVo;
import com.luciano.felipe.arqpayment.entities.ProductSale;
import com.luciano.felipe.arqpayment.entities.Sale;
import com.luciano.felipe.arqpayment.exception.ResourceNotFoundException;
import com.luciano.felipe.arqpayment.repository.ProductSaleRepository;
import com.luciano.felipe.arqpayment.repository.SaleRepository;

@Service
public class SaleService {

	private SaleRepository saleRepository;
	private ProductSaleRepository productSaleRepository;

	@Autowired
	public SaleService(SaleRepository saleRepository,ProductSaleRepository productSaleRepository) {
		this.saleRepository = saleRepository;
		this.productSaleRepository=productSaleRepository;
	}

	public SaleVo create(SaleVo saleVo) {
	    Sale sale =  saleRepository.save(Sale.create(saleVo));
		List<ProductSale> productsSales = new ArrayList<>();
		saleVo.getProducts().forEach(p -> {
			ProductSale productSale = ProductSale.create(p);
			productSale.setSale(sale);
			productsSales.add(productSaleRepository.save(productSale));
		});
		sale.setProducts(productsSales);
		return SaleVo.create(sale);
	}

	public Page<SaleVo> findAll(Pageable pageable) {
		var page = saleRepository.findAll(pageable);
		return page.map(this::convertToSaletVo);

	}
	
	public SaleVo findById(Long id) {
		var sale = saleRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("no records found for this ID"));
				
		return SaleVo.create(sale);
	}

	private SaleVo convertToSaletVo(Sale sale) {
		return SaleVo.create(sale);

	}
}
