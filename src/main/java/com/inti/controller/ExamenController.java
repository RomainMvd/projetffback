package com.inti.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.inti.entities.Cours;
import com.inti.entities.Examen;
import com.inti.service.interfaces.IExamenService;

@RestController
@CrossOrigin
public class ExamenController {

	@Autowired
	IExamenService examenService;
	
	@GetMapping("/examens")
	public List<Examen> findAll() {
		return examenService.findAll();
	}
	
	@GetMapping("/examens/{id}")
	public Examen findOne(@PathVariable Long id) {
		return examenService.findOne(id);
	}
	
	@DeleteMapping("/examens/{id}")
	public void deleteExamen(@PathVariable Long id) {
		examenService.delete(id);
	}
	
	@PostMapping("/examens")
	public String saveExamen(
			@RequestParam(required = false) String nomExamen,
			@RequestParam(required = false) String duree,
			@RequestParam(required = false) String date,
			@RequestParam(required = false) MultipartFile fichierIn,
			@RequestParam(required = false) MultipartFile fichierOut
			//@RequestParam(required = false) Cours cours,
			//@RequestParam(required = false) Correction correction
			) {System.out.println(date);
			
		try {
			Date dateI = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Examen currentExamen = new Examen();
			currentExamen.setNomExamen(nomExamen);
			currentExamen.setDuree(duree);
			currentExamen.setDateExamen(dateI);
			if(fichierIn != null) {
				currentExamen.setFichierExamen(fichierIn.getBytes());
			}
			if(fichierOut != null) {
				currentExamen.setFichierReponseExamen(fichierOut.getBytes());
			}
			//currentExamen.setCours(cours);
			//currentExamen.setCorrection(correction);
			examenService.save(currentExamen);
			return "Brace yourself, examen is coming";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}
	
	@PutMapping("/examens/{id}")
	public String updateExamen(
			@PathVariable Long id,
			@RequestParam(required = false) String nomExamen,
			@RequestParam(required = false) String duree,
			@RequestParam(required = false) Date date,
			@RequestParam(required = false) MultipartFile fichierIn,
			@RequestParam(required = false) MultipartFile fichierOut,
			@RequestParam(required = false) Cours cours,
			@RequestParam(required = false) Correction correction
			) {
		Examen currentExamen = examenService.findOne(id);
		try {
			currentExamen.setNomExamen(nomExamen);
			currentExamen.setDuree(duree);
			currentExamen.setDateExamen(date);
			if(fichierIn != null) {
				currentExamen.setFichierExamen(fichierIn.getBytes());
			}
			if(fichierOut != null) {
				currentExamen.setFichierReponseExamen(fichierOut.getBytes());
			}
			currentExamen.setCours(cours);
			currentExamen.setCorrection(correction);
			examenService.save(currentExamen);
			return "Brace yourself, examen is coming";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Failed";
		}
	}
	
}
