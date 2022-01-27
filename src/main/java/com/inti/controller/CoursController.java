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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entities.Cours;
import com.inti.entities.Evaluation;
import com.inti.entities.Examen;
import com.inti.service.interfaces.ICoursService;

@RestController
@CrossOrigin
public class CoursController {

	@Autowired
	ICoursService coursService;

	@GetMapping("/cours")
	public List<Cours> findAll() {
		return coursService.findAll();
	}

	// A retravailler
	@GetMapping("/cours/classe/{idClasse}")
	public String afficherCoursClasse(@PathVariable String idClasse, @RequestParam(required = false) String e) {
		try {
			List<Cours> cs;
			String msg = "";
			if (e != null) {
				System.out.println("here");
				cs = coursService.afficherCoursClasseEtudiants(idClasse);
			} else {
				cs = coursService.afficherCoursClasse(idClasse);
			}
			for (Cours c : cs) {
				msg = msg + '\n' + c.toString();
			}
			return msg;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Error";
		}
	}

	@GetMapping("/cours/etudiant/{idE}")
	public String afficherCoursEtudiant(@PathVariable String idE) {
		return "k";
	}

	@GetMapping("/cours/{id}")
	public Cours findOne(@PathVariable Long id) {
		return coursService.findOne(id);
	}

	@DeleteMapping("/cours/{id}")
	public void deleteCours(@PathVariable Long id) {
		coursService.delete(id);
	}

	// WON'T BE USED ?
	@PostMapping("/cours")
	public String saveCours(@RequestParam(required = false) String nomCours,
			@RequestParam(required = false) String matiere, @RequestParam(required = false) Double nbrHeure,
			@RequestParam(required = false) MultipartFile fichier,
			@RequestParam(required = false) Set<Evaluation> evaluations,
			@RequestParam(required = false) Set<Examen> examens) {
		try {
			Cours currentCours = new Cours();
			currentCours.setNomCours(nomCours);
			currentCours.setNomMatiere(matiere);
			currentCours.setNbrHeure(nbrHeure);
			if (fichier != null) {
				currentCours.setFichierCours(fichier.getBytes());
			}
			currentCours.setEvaluations(evaluations);
			currentCours.setExamens(examens);
			coursService.save(currentCours);
			return "Uploaded";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}

	@PutMapping("/cours/{id}")
	public String updateCours(@PathVariable Long id, @RequestParam(required = false) String nomCours,
			@RequestParam(required = false) String matiere, @RequestParam(required = false) Double nbrHeure,
			@RequestParam(required = false) MultipartFile fichier,
			@RequestParam(required = false) Set<Evaluation> evaluations,
			@RequestParam(required = false) Set<Examen> examens) {
		Cours currentCours = coursService.findOne(id);
		try {
			currentCours.setNomCours(nomCours);
			currentCours.setNomMatiere(matiere);
			currentCours.setNbrHeure(nbrHeure);
			if (fichier != null) {
				currentCours.setFichierCours(fichier.getBytes());
			}
			currentCours.setEvaluations(evaluations);
			currentCours.setExamens(examens);
			coursService.save(currentCours);
			return "Uploaded";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}

}
