package com.brainyinvoiceai.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.brainyinvoiceai.dto.UserDto;
import com.brainyinvoiceai.entity.Organization;
import com.brainyinvoiceai.entity.Role;
import com.brainyinvoiceai.entity.User;
import com.brainyinvoiceai.repository.OrganizationRepository;
import com.brainyinvoiceai.repository.RoleRepository;
import com.brainyinvoiceai.services.UserService;
import jakarta.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	@GetMapping("/start")
	public String entry() {
		Optional<Organization> orgainztion = organizationRepository.findById(1l);
		if (!orgainztion.isPresent()) {
			Organization OrganizationEntity = Organization.builder().orgName("Org1").address("add1").gstnNo("gstno123")
					.panNo("pan123").tinNo("tinNo123").phone("90909088").email("testing@gmail.com")
					.website("http//www.google.com").term1("term1").term2("term2").logo("").image("").build();
			organizationRepository.save(OrganizationEntity);
		}

		Optional<Role> role = roleRepository.findById(1l);
		if (!role.isPresent()) {
			Role roleEntity = Role.builder().name("ROLE_ADMIN").build();
			roleRepository.save(roleEntity);
		}

		return "start";
	}

	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
		User existing = userService.findByEmail(user.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		userService.saveUser(user);
		return "redirect:/register?success";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}