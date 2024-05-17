package com.brainyinvoiceai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "organization")
@Getter
@Setter
@ToString
public class Organization {

	@Id
	@Column(name = "org_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orgId;
	
	@Column(name = "org_name", nullable = false, unique = true, length = 20)
	private String org_name;
	
	@Column(name = "address", nullable = false, length = 35)
	private String address;
	
	@Column(name = "gstn_no", nullable = false, length = 20)
	private String gstnNo;
	
	@Column(name = "pan_no", nullable = false, length = 20)
	private String panNo;
	
	@Column(name = "tin_no", nullable = false, length = 20)
	private String tinNo;
	
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;
	
	@Column(name = "email", nullable = false, length = 20)
	private String email;
	
	@Column(name = "website", nullable = false, length = 20)
	private String website;
	
	@Column(name = "term1", nullable = false, length = 20)
	private String term1;
	
	@Column(name = "term2", nullable = false, length = 20)
	private String term2;
	
	@Column(name = "logo", nullable = false, unique = true, length = 20)
	private String logo;
    
    @Column(name = "image", nullable = false, unique = true, length = 20)
	private String image;

	
}
