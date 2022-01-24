package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Enseignant;
import com.inti.service.interfaces.IEnseignantService;
import com.inti.service.interfaces.ITestSQLService;

@RestController
@CrossOrigin
public class TestSQLController {

	@Autowired
	ITestSQLService testSQLService;
	
	@Autowired
	IEnseignantService enseignantService;
	
	@GetMapping("/cours/evaluation/moy")
	public String avgEvalCours(@RequestParam String id) {
		Double value = testSQLService.avgEvaluationCours(id);
		return "la note est de " + value;
	}
	
	@GetMapping("/personnes/enseignant/cours/evaluation/moy")
	public String avgEvaluationCoursEnseignant(@RequestParam String ide) {
		Long idE = Long.parseLong(ide);
		try {
			Enseignant testEnseignant=enseignantService.findOne(idE);
		}catch(Exception ex) {
			ex.printStackTrace();
			return "error ce n'est pas un enseignant";
		}
		Double value = testSQLService.avgEvaluationCoursEnseignant(ide);
			return "l'enseignant a un score de " + value;
	}
}
