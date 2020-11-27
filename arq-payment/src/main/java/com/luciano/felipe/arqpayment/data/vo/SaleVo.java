package com.luciano.felipe.arqpayment.data.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.luciano.felipe.arqpayment.entities.ProductSale;
import com.luciano.felipe.arqpayment.entities.Sale;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","date","products","totalValue"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class SaleVo extends RepresentationModel<SaleVo> implements Serializable  {
	
	private static final long serialVersionUID = 6385638194105832382L;
	
	@JsonProperty("id")	
	private Long id;
	@JsonProperty("date")
	private Date date;
	
    @JsonProperty("products")
	private List<ProductSale> products;
	
    @JsonProperty("totalValue")
	private Double totalValue;
    
    public static SaleVo create(Sale sale) {
		return new ModelMapper().map(sale, SaleVo.class);
    	
    }

}
