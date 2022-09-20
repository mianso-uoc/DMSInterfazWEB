package com.mianso.dsmantenimiento.DSMInterfazWEB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

//	@GetMapping("/")
//	public String index(Model model, Principal principal) {
//		model.addAttribute("message", "You are logged in as " + principal.getName());
//		return "inicio";
//	}

	@RequestMapping({ "/inicio" })
	public String inicio() {
		return "inicio";
	}

//	@RequestMapping(value =  "/login", method = RequestMethod.POST)
//	public String acceso(@RequestParam("usuario") String usuario, @RequestParam("password") String password) {
//		System.out.println("EMAIL: " + usuario);
//		return "inicio";
//	}

}
