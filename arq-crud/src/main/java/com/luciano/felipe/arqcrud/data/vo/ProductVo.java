package com.luciano.felipe.arqcrud.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.luciano.felipe.arqcrud.entities.Product;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","name","stock","price"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class ProductVo extends RepresentationModel<ProductVo> implements Serializable {

	private static final long serialVersionUID = 8579108491230964960L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("stock")
	private Integer stock;

	@JsonProperty("price")
	private Double price;

	public static ProductVo create(Product product) {
		return new ModelMapper().map(product, ProductVo.class);
	}

}
