package com.mianso.dsmantenimiento.DSMInterfazWEB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Administrator;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Company;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Manager;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.User;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.UserForm;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Welder;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.CompanyRepository;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CompanyRepository<Company> companyRepository;

	@RequestMapping("")
	public String getUsers(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "users";
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String newUser(Model model) {

		UserForm userForm = new UserForm();
		userForm.setUser(new Manager());
		userForm.setType("Responsable");
		model.addAttribute("userForm", userForm);
		System.out.println("______________________________________________________________");
		System.out.println("Usuario tipo " + userForm.getUser().getType());
		System.out.println("______________________________________________________________");

		List<Company> companies = companyRepository.findAll();
		model.addAttribute("companies", companies);

		return "userForm";

	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String createUser(@ModelAttribute UserForm userForm, RedirectAttributes redirectAttributes) {

		System.out.println("______________________________________________________________");
		System.out.println("Crear usuario " + userForm.getType());
		System.out.println("______________________________________________________________");
		
		User user = userForm.getUser();
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    
		switch (userForm.getType()) {

		case "Responsable":
			Manager manager = new Manager(user.getEmail(), user.getName(), user.getPassword());
			manager.setCompany(userForm.getCompany());
			user = userRepository.save(manager);
			break;

		case "Soldador":
			Welder welder = new Welder(user.getEmail(), user.getName(), user.getPassword());
			welder.setCompany(userForm.getCompany());
			user = userRepository.save(welder);
			break;

		case "Administrador":
			Administrator admin = new Administrator(user.getEmail(), user.getName(), user.getPassword());
			user = userRepository.save(admin);
			break;
		}
		
		System.out.println("______________________________________________________________");
		System.out.println("CREADO " + user.getId());
		System.out.println("______________________________________________________________");
		
		redirectAttributes.addFlashAttribute("msgSuccess", "Usuario " + user.getId() + " - " + user.getName() + " creado correctamente");
		
		return "redirect:/users";

	}
}
