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
import org.springframework.web.multipart.MultipartFile;

import com.inti.entities.Correction;
import com.inti.entities.Examen;
import com.inti.service.interfaces.ICorrectionService;

@RestController
@CrossOrigin
public class CorrectionController {

	@Autowired
	ICorrectionService correctionService;
	
	@GetMapping("/corrections")
	public List<Correction> findAll() {
		return correctionService.findAll();
	}
	
	@GetMapping("/corrections/{id}")
	public Correction findOne(@PathVariable Long id) {
		return correctionService.findOne(id);
	}
	
	@DeleteMapping("/corrections/{id}")
	public void deleteCorrection(@PathVariable Long id) {
		correctionService.delete(id);
	}
	
	@PostMapping("/corrections")
	public String saveCorrection(
			@RequestParam(required = false) Double noteExamen,
			@RequestParam(required = false) String commentaire,
			@RequestParam(required = false) String matiere, 
			@RequestParam(required = false) MultipartFile fichierCorrection, 
			@RequestParam(required = false) Examen examen
			) {
		try {
		Correction currentCorrection = new Correction();
		currentCorrection.setNoteExamen(noteExamen);
		currentCorrection.setCommentaireEnseignant(commentaire);
		currentCorrection.setNomMatiere(matiere);
		if (fichierCorrection != null) {
			currentCorrection.setFichierCorrection(fichierCorrection.getBytes());
		}
		currentCorrection.setExamen(examen);
		correctionService.save(currentCorrection);
		return "Uploaded";
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}	
	}
	
	@PutMapping("/corrections/{id}")
	public String updateCorrection(@PathVariable Long id,
			@RequestParam(required = false) Double noteExamen,
			@RequestParam(required = false) String commentaire,
			@RequestParam(required = false) String matiere, 
			@RequestParam(required = false) MultipartFile fichierCorrection, 
			@RequestParam(required = false) Examen examen) {
		Correction currentCorrection = correctionService.findOne(id);
		try {
			currentCorrection.setNoteExamen(noteExamen);
			currentCorrection.setCommentaireEnseignant(commentaire);
			currentCorrection.setNomMatiere(matiere);
			if (fichierCorrection != null) {
				currentCorrection.setFichierCorrection(fichierCorrection.getBytes());
			}
			currentCorrection.setExamen(examen);
			correctionService.save(currentCorrection);
			return "Uploaded";
			}catch (Exception ex) {
				ex.printStackTrace();
				return "Failed";
			}	
	}
}
