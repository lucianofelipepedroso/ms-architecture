package com.luciano.felipe.arqpayment.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luciano.felipe.arqpayment.data.vo.SaleVo;
import com.luciano.felipe.arqpayment.service.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {
	
	private final SaleService saleService;
	
	private final PagedResourcesAssembler<SaleVo> pagedResourcesAssembler;

	@Autowired
	public SaleController(SaleService saleService, PagedResourcesAssembler<SaleVo> pagedResourcesAssembler) {
		this.saleService = saleService;
		this.pagedResourcesAssembler = pagedResourcesAssembler;
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public SaleVo findById(@PathVariable("id") Long id) {
		SaleVo saleVo = saleService.findById(id);
		saleVo.add(linkTo(methodOn(SaleController.class).findById(id)).withSelfRel());
		return saleVo;
	}

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {

		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "date"));

		Page<SaleVo> sales = saleService.findAll(pageable);
		sales.stream().forEach(p -> linkTo(methodOn(SaleController.class).findById(p.getId())).withSelfRel());

		PagedModel<EntityModel<SaleVo>> pagedModel = pagedResourcesAssembler.toModel(sales);

		return new ResponseEntity<>(pagedModel, HttpStatus.OK);

	}

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public SaleVo create(@RequestBody SaleVo productVo) {
		SaleVo saleVo = saleService.create(productVo);
		saleVo.add(linkTo(methodOn(SaleController.class).findById(saleVo.getId())).withSelfRel());
		return saleVo;

	}
	
	

}
