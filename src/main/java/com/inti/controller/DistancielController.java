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

import com.inti.entities.Distanciel;
import com.inti.entities.Evaluation;
import com.inti.entities.Examen;
import com.inti.service.interfaces.IDistancielService;

@RestController
@CrossOrigin
@RequestMapping("/cours")
public class DistancielController {

	@Autowired
	IDistancielService distancielService;
	
	@GetMapping("/distanciels")
	public List<Distanciel> findAll() {
		return distancielService.findAll();
	}
	
	@GetMapping("/distanciels/{id}")
	public Distanciel findOne(@PathVariable Long id) {
		return distancielService.findOne(id);
	}
	
	@DeleteMapping("/distanciels/{id}")
	public void deleteDistanciel(@PathVariable Long id) {
		distancielService.delete(id);
	}
	
	@PostMapping("/distanciels")
	public String saveDistanciel(
			@RequestParam(required = false) String nomCours,
			@RequestParam(required = false) String matiere,
			@RequestParam(required = false) Double nbrHeure,
			@RequestParam(required = false) MultipartFile fichier,
			@RequestParam(required = false) Set<Evaluation> evaluations,
			@RequestParam(required = false) Set<Examen> examens,
			@RequestParam(required = false) String lien
			) {
		try {
			Distanciel currentDistanciel = new Distanciel();
			currentDistanciel.setNomCours(nomCours);
			currentDistanciel.setNomMatiere(matiere);
			currentDistanciel.setNbrHeure(nbrHeure);
			if (fichier != null) {
				currentDistanciel.setFichierCours(fichier.getBytes());
			}
			currentDistanciel.setEvaluations(evaluations);
			currentDistanciel.setExamens(examens);
			currentDistanciel.setLienZoom(lien);
			distancielService.save(currentDistanciel);
			return "Uploaded";
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}
	
	@PutMapping("/distanciels/{id}")
	public String updateDistanciel(
			@PathVariable Long id,
			@RequestParam(required = false) String nomCours,
			@RequestParam(required = false) String matiere,
			@RequestParam(required = false) Double nbrHeure,
			@RequestParam(required = false) MultipartFile fichier,
			@RequestParam(required = false) Set<Evaluation> evaluations,
			@RequestParam(required = false) Set<Examen> examens,
			@RequestParam(required = false) String lien
			) {
		Distanciel currentDistanciel = distancielService.findOne(id);
		try {
			currentDistanciel.setNomCours(nomCours);
			currentDistanciel.setNomMatiere(matiere);
			currentDistanciel.setNbrHeure(nbrHeure);
			if (fichier != null) {
				currentDistanciel.setFichierCours(fichier.getBytes());
			}
			currentDistanciel.setEvaluations(evaluations);
			currentDistanciel.setExamens(examens);
			currentDistanciel.setLienZoom(lien);
			distancielService.save(currentDistanciel);
			return "Uploaded";
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}
}
