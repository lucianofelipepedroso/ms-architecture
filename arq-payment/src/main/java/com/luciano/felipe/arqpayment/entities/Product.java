package com.luciano.felipe.arqpayment.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.luciano.felipe.arqpayment.data.vo.ProductVo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@Entity(name = "tb_product")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product implements Serializable {

	private static final long serialVersionUID = -3273436320786069777L;
	
	@Id
	private Long id;
	
	@Column(name = "stock", nullable = false)
	private Integer stock;
	
	 public static Product create(ProductVo productVo) {
			return new ModelMapper().map(productVo, Product.class);
	    	
	    }

}
