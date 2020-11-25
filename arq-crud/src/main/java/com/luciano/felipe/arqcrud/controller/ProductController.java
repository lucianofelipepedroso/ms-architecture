package com.luciano.felipe.arqcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luciano.felipe.arqcrud.data.vo.ProductVo;
import com.luciano.felipe.arqcrud.service.ProductService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	private ProductService productService;

	private PagedResourcesAssembler<ProductVo> pagedResourcesAssembler;

	@Autowired
	public ProductController(ProductService productService,
			PagedResourcesAssembler<ProductVo> pagedResourcesAssembler) {
		this.productService = productService;
		this.pagedResourcesAssembler = pagedResourcesAssembler;
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ProductVo findById(@PathVariable("id") Long id) {
		ProductVo productVo = productService.findById(id);
		productVo.add(linkTo(methodOn(ProductController.class).findById(id)).withSelfRel());
		return productVo;
	}

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {

		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "name"));

		Page<ProductVo> produtos = productService.findAll(pageable);
		produtos.stream().forEach(p -> linkTo(methodOn(ProductController.class).findById(p.getId())).withSelfRel());

		PagedModel<EntityModel<ProductVo>> pagedModel = pagedResourcesAssembler.toModel(produtos);

		return new ResponseEntity<>(pagedModel, HttpStatus.OK);

	}

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public ProductVo create(@RequestBody ProductVo productVo) {
		ProductVo proVo = productService.create(productVo);
		proVo.add(linkTo(methodOn(ProductController.class).findById(proVo.getId())).withSelfRel());
		return proVo;

	}

	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public ProductVo update(@RequestBody ProductVo productVo) {
		ProductVo proVo = productService.update(productVo);
		proVo.add(linkTo(methodOn(ProductController.class).findById(productVo.getId())).withSelfRel());
		return proVo;

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		productService.delete(id);
		return ResponseEntity.ok().build();

	}

}
