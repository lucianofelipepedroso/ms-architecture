package com.luciano.felipe.arqpayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luciano.felipe.arqpayment.data.vo.SaleVo;
import com.luciano.felipe.arqpayment.entities.Sale;
import com.luciano.felipe.arqpayment.repository.SaleRepository;

@Service
public class SaleService {

	private SaleRepository saleRepository;

	@Autowired
	public SaleService(SaleRepository saleRepository) {
		this.saleRepository = saleRepository;
	}

	public SaleVo create(SaleVo saleVo) {
		SaleVo saleVoReturn = SaleVo.create(saleRepository.save(Sale.create(saleVo)));
		return saleVoReturn;
	}

	public Page<SaleVo> findAll(Pageable pageable) {
		var page = saleRepository.findAll(pageable);
		return page.map(this::convertToSaletVo);

	}

	private SaleVo convertToSaletVo(Sale sale) {
		return SaleVo.create(sale);

	}
}
