package com.luciano.felipe.arqpayment.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.luciano.felipe.arqpayment.entities.ProductSale;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","idProduct","amount"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class ProductSaleVo extends RepresentationModel<ProductSaleVo> implements Serializable{
	
	private static final long serialVersionUID = 1232215303005294116L;
	
    @JsonPropertyOrder("id")
	private Long id;
	@JsonPropertyOrder("idProduct")
	private Long idProduct;
	@JsonPropertyOrder("amount")
	private Integer amount;

    
    public static ProductSaleVo create(ProductSale productSale) {
    	return new ModelMapper().map(productSale, ProductSaleVo.class);
    }

}
