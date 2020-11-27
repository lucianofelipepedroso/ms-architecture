package com.luciano.felipe.arqpayment.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.luciano.felipe.arqpayment.entities.Product;
import com.luciano.felipe.arqpayment.entities.Sale;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","stock"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class ProductVo extends RepresentationModel<ProductVo> implements Serializable{

	private static final long serialVersionUID = 6188140026430776436L;
	
	@JsonPropertyOrder("id")
	private Long id;
	
	@JsonPropertyOrder("stock")
	private Integer stock;


	  public static ProductVo create(Product product) {
			return new ModelMapper().map(product, ProductVo.class);
	    	
	    }
}
