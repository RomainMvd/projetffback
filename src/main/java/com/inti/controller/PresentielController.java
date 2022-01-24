package com.inti.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entities.Presentiel;
import com.inti.entities.Evaluation;
import com.inti.entities.Examen;
import com.inti.service.interfaces.IPresentielService;

@RestController
@CrossOrigin
@RequestMapping("/cours")
public class PresentielController {

	@Autowired
	IPresentielService presentielService;
	
	@GetMapping("/presentiels")
	public List<Presentiel> findAll() {
		return presentielService.findAll();
	}
	
	@GetMapping("/presentiels/{id}")
	public Presentiel findOne(@PathVariable Long id) {
		return presentielService.findOne(id);
	}
	
	@DeleteMapping("/presentiels/{id}")
	public void deletePresentiel(@PathVariable Long id) {
		presentielService.delete(id);
	}
	
	@PostMapping("/presentiels")
	public String savePresentiel(
			@RequestParam(required = false) String nomCours,
			@RequestParam(required = false) String matiere,
			@RequestParam(required = false) Double nbrHeure,
			@RequestParam(required = false) MultipartFile fichier,
			@RequestParam(required = false) Set<Evaluation> evaluations,
			@RequestParam(required = false) Set<Examen> examens,
			@RequestParam(required = false) String salle
			) {
		try {
			Presentiel currentPresentiel = new Presentiel();
			currentPresentiel.setNomCours(nomCours);
			currentPresentiel.setNomMatiere(matiere);
			currentPresentiel.setNbrHeure(nbrHeure);
			if (fichier != null) {
				currentPresentiel.setFichierCours(fichier.getBytes());
			}
			currentPresentiel.setEvaluations(evaluations);
			currentPresentiel.setExamens(examens);
			currentPresentiel.setSalle(salle);
			presentielService.save(currentPresentiel);
			return "Uploaded";
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}
	
	@PutMapping("/presentiels/{id}")
	public String updatePresentiel(
			@PathVariable Long id,
			@RequestParam(required = false) String nomCours,
			@RequestParam(required = false) String matiere,
			@RequestParam(required = false) Double nbrHeure,
			@RequestParam(required = false) MultipartFile fichier,
			@RequestParam(required = false) Set<Evaluation> evaluations,
			@RequestParam(required = false) Set<Examen> examens,
			@RequestParam(required = false) String salle
			) {
		Presentiel currentPresentiel = presentielService.findOne(id);
		try {
			currentPresentiel.setNomCours(nomCours);
			currentPresentiel.setNomMatiere(matiere);
			currentPresentiel.setNbrHeure(nbrHeure);
			if (fichier != null) {
				currentPresentiel.setFichierCours(fichier.getBytes());
			}
			currentPresentiel.setEvaluations(evaluations);
			currentPresentiel.setExamens(examens);
			currentPresentiel.setSalle(salle);
			presentielService.save(currentPresentiel);
			return "Uploaded";
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}
}
