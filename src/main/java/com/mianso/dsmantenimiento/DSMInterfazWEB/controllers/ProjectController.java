package com.mianso.dsmantenimiento.DSMInterfazWEB.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Manager;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Proyecto;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.User;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.ProyectoRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProyectoRepository<Proyecto> proyectoRepository;

	@RequestMapping("")
	public String getProjects(Model model) {
		return "projects";
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String newProject(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Proyecto project = new Proyecto();
		if (authentication.getPrincipal() instanceof Manager) {
			project.setManager((Manager)authentication.getPrincipal());
			model.addAttribute("proyecto", project);
		}

		return "proyectoForm";

	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String createProject(@ModelAttribute Proyecto proyecto, RedirectAttributes redirectAttributes, User user) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication.getPrincipal() instanceof Manager) {
			proyecto.setManager((Manager)authentication.getPrincipal());
			proyectoRepository.save(proyecto);
			
		} else {
			System.out.println("Only managers can create projects!");
		}
		return "redirect:/inicio";

	}
}
