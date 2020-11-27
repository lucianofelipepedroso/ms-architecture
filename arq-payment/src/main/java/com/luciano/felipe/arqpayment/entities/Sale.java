package com.luciano.felipe.arqpayment.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import com.luciano.felipe.arqpayment.data.vo.SaleVo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_sale")
public class Sale implements Serializable {

	private static final long serialVersionUID = 9078852980776294070L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "data", nullable = false)
	private Date date;

	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "sale", fetch = FetchType.LAZY)
	private List<ProductSale> products;

	@Column(name = "totalValue", nullable = false)
	private Double totalValue;

	public static Sale create(SaleVo saleVo) {
		return new ModelMapper().map(saleVo, Sale.class);

	}

}
