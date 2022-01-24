package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Cours;
import com.inti.entities.Evaluation;
import com.inti.service.interfaces.IEvaluationService;

@RestController
@CrossOrigin
public class EvaluationController {

	@Autowired
	IEvaluationService evaluationService;
	
	@GetMapping("/evaluations")
	public List<Evaluation> findAll() {
		return evaluationService.findAll();
	}
	
	@GetMapping("/evaluations/{id}")
	public Evaluation findOne(@PathVariable Long id) {
		return evaluationService.findOne(id);
	}
	
	@DeleteMapping("/evaluations/{id}")
	public void deleteEvaluation(@PathVariable Long id) {
		evaluationService.delete(id);
	}
	
	@PostMapping("/evaluations")
	public String saveEvaluation(
			@RequestParam(required = false) String commentaire,
			@RequestParam(required = false) Double noteCours,
			@RequestParam(required = false) Cours cours
			) {
		try {
			Evaluation currentEvaluation = new Evaluation();
			currentEvaluation.setCommentaire(commentaire);
			currentEvaluation.setNoteCours(noteCours);
			currentEvaluation.setCours(cours);
			evaluationService.save(currentEvaluation);
			return "Uploaded";
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}
	
	@PutMapping("/evaluations/{id}")
	public String updateEvaluation(@PathVariable Long id,
			@RequestParam(required = false) String commentaire,
			@RequestParam(required = false) Double noteCours,
			@RequestParam(required = false) Cours cours
			) {
		Evaluation currentEvaluation = evaluationService.findOne(id);
		try {
			currentEvaluation.setCommentaire(commentaire);
			currentEvaluation.setCours(cours);
			currentEvaluation.setNoteCours(noteCours);
			evaluationService.save(currentEvaluation);
			return "Uploaded";
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}
}
