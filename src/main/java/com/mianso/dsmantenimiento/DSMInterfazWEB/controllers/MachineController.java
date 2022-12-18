package com.mianso.dsmantenimiento.DSMInterfazWEB.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Maquina;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.ProyectoMaquina;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.MaquinaRepository;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.ProyectoMaquinaRepository;

@Controller
@RequestMapping("/machines")
public class MachineController {
	
	@Autowired
	private MaquinaRepository<Maquina> maquinaRepository;
	
	@Autowired
	private ProyectoMaquinaRepository<ProyectoMaquina> proyectoMaquinaRepository;

	@RequestMapping("")
	public String getMachines(Model model) {
		List<Maquina> machines = maquinaRepository.findAll();
		model.addAttribute("machines", machines);
		return "machines";
	}
	
	@GetMapping("/{id}")
	public String getMachineById(@PathVariable("id") long id, Model model) {
		Optional<Maquina> machineData = maquinaRepository.findById(id);

		if (machineData.isPresent()) {
			model.addAttribute("machine", machineData.get());
			return "machine";
		} else {
		}
		return "machine";

	}
}
