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
@Table(name = "invoice_product")
@Getter
@Setter
@ToString
public class InvoiceProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceProductId;
	
	//Job/Product
	@Column(name = "product_type", nullable = false, unique = true, length = 20)
	private String prodcutType;
	
	@Column(name = "quantity", nullable = false, unique = true, length = 20)
	private String quantity;
	
	@Column(name = "rate", nullable = false, unique = true)
	private double rate;
	
	//(Qty*rate) 
	@Column(name = "amount", nullable = false, unique = true)
	private double amount;
	
	//TaxRate [stores the GST rate applicable/ HSNCode ]
	@Column(name = "tax_rate", nullable = false, unique = true)
	private double tax_rate;
	
	// stores the total amount including GST.]
	@Column(name = "total", nullable = false, unique = true)
	private double total;

	
	@Column(name = "sgst", nullable = false, unique = true)
	private double sgst;
	
	@Column(name = "igst", nullable = false, unique = true)
	private double igst;
			
	@Column(name = "cgst", nullable = false, unique = true)
	private double cgst;
			
	@ManyToOne
    @JoinColumn(name="product_id", nullable=false)
	private Product productId;
	
	@ManyToOne
    @JoinColumn(name="invoice_id", nullable=false)
	private Invoice invoiceId;
	
	@ManyToOne
    @JoinColumn(name="org_id", nullable=false)
	private Organization orgId;
}
