package com.luciano.felipe.arqcrud.service;

import java.lang.module.ResolutionException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luciano.felipe.arqcrud.data.vo.ProductVo;
import com.luciano.felipe.arqcrud.entities.Product;
import com.luciano.felipe.arqcrud.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductVo create(ProductVo productVo) {
		ProductVo productVoReturn = ProductVo.create(productRepository.save(Product.create(productVo)));
		return productVoReturn;
	}

	public Page<ProductVo> findAll(Pageable pageable) {
		var page = productRepository.findAll(pageable);
		return page.map(this::convertToProductVo);

	}

	public ProductVo findById(Long id) {
		var product = productRepository.findById(id)
				.orElseThrow(() -> new ResolutionException("no records found for this ID"));
		return ProductVo.create(product);
	}

	public ProductVo update(ProductVo productVo) {
		final Optional<Product> optional = productRepository.findById(productVo.getId());

		if (!optional.isPresent()) {
			throw new ResolutionException("no records found for this ID");
		}

		return ProductVo.create(productRepository.save(Product.create(productVo)));
	}

	public void delete(Long id) {
		var product = productRepository.findById(id)
				.orElseThrow(() -> new ResolutionException("no records found for this ID"));

		productRepository.delete(product);
	}

	private ProductVo convertToProductVo(Product product) {
		return ProductVo.create(product);
	}

}
