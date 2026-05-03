package tn.esprit.Exam.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Exam.Services.IEtudiantService;



@RestController
@Slf4j

public class Controller {
	@Autowired // bch njib beha classe sans instantiation
	IEtudiantService Is;

	
	/*
	@PostMapping("/Evenement/Add")
	Evenement ajouterEvenement(@RequestBody Evenement Evenement) {

		return Is.addEvenement(Evenement);
	}
	*/
	
	
}
