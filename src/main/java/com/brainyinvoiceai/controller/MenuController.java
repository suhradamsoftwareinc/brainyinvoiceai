package com.brainyinvoiceai.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.brainyinvoiceai.config.CustomUserDetails;

@Controller
public class MenuController {

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();
        model.addAttribute("company", userDetails.getOrgName());
		return "dashboard";
	}
	
	@GetMapping("/invoice")
	public String invoice() {
		return "invoice";
	}
	
	@GetMapping("/party")
	public String party() {
		return "party";
	}
	
	@GetMapping("/bank")
	public String bank() {
		return "bank";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
