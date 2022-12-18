package com.mianso.dsmantenimiento.DSMInterfazWEB.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Pieza;
import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Reading;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.PiezaRepository;
import com.mianso.dsmantenimiento.DSMInterfazWEB.repository.ReadingRepository;

@Controller
@RequestMapping("/pieces")
public class PieceController {
	
	@Autowired
	private PiezaRepository<Pieza> piezaRepository;
	
	@Autowired
	private ReadingRepository<Reading> readingRepository;

	@GetMapping("/{id}")
	public String getPieceById(@PathVariable("id") long id, Model model) {
		
		Optional<Pieza> pieceData = piezaRepository.findById(id);

		if (pieceData.isPresent()) {
//			Random rand = new Random();
//
//			Reading reading = new Reading();
//			reading.setPieza(pieceData.get());
//			reading.setVoltage(rand.nextFloat() * 10);
//			
//			readingRepository.save(reading);
			model.addAttribute("pieza", pieceData.get());
			return "piece";
		} else {
		}
		return "piece";

	}
}
