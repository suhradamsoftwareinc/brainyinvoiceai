package com.brainyinvoiceai.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	 private Long id;
	 
	 @NotEmpty(message = "{registration.product.title}")
	 private String title;
	 
	 @NotEmpty(message = "{registration.product.type}")
	 private String type; //job or product
	 
	 @Min(value = 1, message = "Product unit price must be greater or equal to 1")
	 @Max(value = 9999, message = "Product unit prices must be less than or equal to 9999")
	 @NotNull(message = "{registration.product.unitPrice}")
	 private Float unitPrice;
	 
	 @NotEmpty(message = "{registration.product.hsncode}")
	 private String hsnCode;
	 
	 @Min(value = 1, message = "Product unit price must be greater or equal to 1")
	 @Max(value = 9999, message = "Product unit prices must be less than or equal to 9999")
	 private Float taxRate;
	 
	 @NotEmpty(message = "{registration.product.description}")
	 private String description;
}