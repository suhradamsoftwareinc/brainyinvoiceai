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
@Table(name = "logistic")
@Getter
@Setter
@ToString
public class Logistic {

	@Id
	@Column(name = "logistic_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logisticId;
	
	@Column(name = "name", nullable = false, unique = true, length = 20)
	private String name;
	
	@ManyToOne
    @JoinColumn(name="org_id", nullable=false)
	private Organization orgId;
}
