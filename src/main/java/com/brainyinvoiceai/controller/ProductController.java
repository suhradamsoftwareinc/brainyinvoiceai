package com.brainyinvoiceai.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.brainyinvoiceai.config.CustomUserDetails;
import com.brainyinvoiceai.config.MyCustomNumberEditor;
import com.brainyinvoiceai.dto.ProductDto;

import jakarta.validation.Valid;

@Controller
public class ProductController {

	@InitBinder
    public void initBinder(WebDataBinder binder) {
       binder.registerCustomEditor(Float.class,new MyCustomNumberEditor(Float.class, false));
    }
	
	@GetMapping("/product")
	public String product() {
		return "product";
	}
	
	@GetMapping("/product/create")
	public String productSave(Model model) {
		ProductDto product = new ProductDto();
		model.addAttribute("product", product);
		return "product_create";
	}
	
	@PostMapping("/product/create")
	public String registration(@Valid @ModelAttribute("product") ProductDto product, BindingResult result, Model model, RedirectAttributes atts) {
		System.out.println("I am here...");
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();
		
        System.out.print("--"+userDetails.getUsername());
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product_create";
		}
		//userService.saveUser(user);
		return "redirect:/product/create?success";
	}
}
