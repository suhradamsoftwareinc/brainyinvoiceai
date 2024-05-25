package com.brainyinvoiceai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name = "product_name", nullable = false, unique = true, length = 20)
	private String product_name;
	
	@Column(name = "per_unit_price", nullable = false, unique = true)
	private double per_unit_price;
	
	@Column(name = "tax_rate", nullable = false, unique = true)
	private double taxRate;
	
	@Column(name = "hsn_code", nullable = false, unique = true, length = 20)
	private String hsnCode;
	
	@ManyToOne
    @JoinColumn(name="org_id", nullable=false)
	private Organization orgId;
	
}
