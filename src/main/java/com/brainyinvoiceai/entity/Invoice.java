package com.brainyinvoiceai.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@ToString
public class Invoice {

	@Id
	@Column(name = "invoice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceId;

	@Column(name = "invoice_name", nullable = false, unique = true, length = 20)
	private String invoiceName;

	@Column(name = "invoice_number", nullable = false, unique = true, length = 20)
	private String invoiceNumber;

	@jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
	@Column(name = "invoice_date", nullable = false, updatable = false)
	private Date invoiceDate;

	// TotalAmount [represents the total amount before tax]
	@Column(name = "total_amount_excludes_tax", nullable = false, unique = true)
	private double totalAmountExcludesTax;

	// [holds the calculated GST amount]
	@Column(name = "tax_amount", nullable = false, unique = true)
	private double taxAmount;

	// [ stores the total amount including GST]
	@Column(name = "grand_total", nullable = false, unique = true)
	private double grandTotal;

	// [PAID/UNPAID]
	@Column(name = "payment_status", nullable = false, unique = true, length = 10)
	private String paymentStatus;

	// State Tax
	@Column(name = "sgst", nullable = false, unique = true)
	private double sgst;

	// Internal Tax
	@Column(name = "igst", nullable = false, unique = true)
	private double igst;

	// Central Tax
	@Column(name = "cgst", nullable = false, unique = true)
	private double cgst;

	// [Original/Duplicate/Triplicate]
	@Column(name = "invoice_level", nullable = false, unique = true, length = 10)
	private String invoiceLevel;

	// [Bank/Cash]
	@Column(name = "payment_type", nullable = false, unique = true, length = 10)
	private String paymentType;

	@Column(name = "roundOff", nullable = false, unique = true)
	private double roundOff;

	@ManyToOne
	@JoinColumn(name = "party_id", nullable = false)
	private Party partyId;

	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bankId;

	@ManyToOne
	@JoinColumn(name = "org_id", nullable = false)
	private Organization orgId;

}
