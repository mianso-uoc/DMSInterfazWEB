package com.mianso.dsmantenimiento.DSMInterfazWEB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Maquina;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Proyecto;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.ProyectoMaquina;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.User;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.MaquinaRepository;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.ProyectoMaquinaRepository;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.ProyectoRepository;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.UserRepository;

@Controller
public class InicioController {
	
	@Autowired
	private ProyectoRepository<Proyecto> proyectoRepository;
	@Autowired
	private MaquinaRepository<Maquina> maquinaRepository;
	@Autowired
	private ProyectoMaquinaRepository<ProyectoMaquina> proyectoMaquinaRepository;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping({ "/inicio" })
	public String inicio() {
		
//		Proyecto p = new Proyecto();
//		p.setName("PROY1");
//		
//		Maquina m = new Maquina();
//		m.setSerialNumber("111222333");
//		
//		Proyecto p1 = proyectoRepository.save(p);
//		Maquina m1 = maquinaRepository.save(m);
//		
//		ProyectoMaquina pm = new ProyectoMaquina();
//		pm.setMaquina(m1);
//		pm.setProyecto(p1);
//		
//		pm = proyectoMaquinaRepository.save(pm);
//		Pieza pi = new Pieza();
//		pi.setName("Pieza");
//		pi.setProyectoMaquina(pm);
//		piezaRepository.save(pi);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		user = userRepository.findByEmail(user.getUsername());
		
		Authentication newAuth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		
		return "inicio";
	}

}
