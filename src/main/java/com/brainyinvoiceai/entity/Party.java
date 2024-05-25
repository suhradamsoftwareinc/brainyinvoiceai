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
@Table(name = "party")
@Getter
@Setter
@ToString
public class Party {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer partyId;
	    
	    @Column(name = "partyName", nullable = false, unique = true, length = 20)
		private String partyName;
	    
	    @Column(name = "address1", nullable = false, unique = true, length = 20)
		private String address1;
	    
	    @Column(name = "address2", nullable = false, unique = true, length = 20)
		private String address2;
	    
	    @Column(name = "gstn_num", nullable = false, unique = true, length = 20)
		private String gstnNum;
	    
	    @Column(name = "pan_num", nullable = false, unique = true, length = 20)
		private String panNum;
	    
	    @Column(name = "phone", nullable = false, unique = true, length = 20)
		private String phone;
	   
	    @Column(name = "email", nullable = false, unique = true, length = 20)
		private String email;
	    
	    @Column(name = "type", nullable = false, unique = true, length = 20)// like - supplier or recipient
		private String type;
	    
	    @ManyToOne
	    @JoinColumn(name="org_id", nullable=false)
		private Organization orgId;
	    
}
