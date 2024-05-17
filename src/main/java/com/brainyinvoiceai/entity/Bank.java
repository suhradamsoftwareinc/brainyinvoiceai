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
@Table(name = "bank")
@Getter
@Setter
@ToString
public class Bank {

	@Id
	@Column(name = "bank_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankId;
	
	@Column(name = "bank_name", nullable = false, unique = true, length = 30)
	private String bank_name;
	
	@Column(name = "bank_ac_no", nullable = false, unique = true, length = 20)
	private String bank_ac_no;
	
	@Column(name = "ifcs_code", nullable = false, unique = true, length = 20)
	private String ifcsCode;
	
	@Column(name = "branch_name", nullable = false, unique = true, length = 30)
	private String branch_name;
	
	
	@ManyToOne
    @JoinColumn(name="org_id", nullable=false)
	private Organization orgId;
}
