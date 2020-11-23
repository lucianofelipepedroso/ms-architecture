package com.luciano.felipe.arqcrud.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.luciano.felipe.arqcrud.data.vo.ProductVo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product implements Serializable {

	private static final long serialVersionUID = -2252940252063229921L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "stock", nullable = false)
	private Integer stock;

	@Column(name = "price", nullable = false)
	private Double price;
	
	
	public static Product create(ProductVo productVo) {
		return new ModelMapper().map(productVo,Product.class);
	}

}
