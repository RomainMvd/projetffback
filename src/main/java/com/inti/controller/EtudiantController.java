package com.inti.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.inti.entities.Etudiant;
import com.inti.entities.Evaluation;
import com.inti.entities.Role;
import com.inti.service.interfaces.ICoursService;
import com.inti.service.interfaces.IEtudiantService;
import com.inti.service.interfaces.IEvaluationService;

@RestController
@CrossOrigin
public class EtudiantController {

	@Autowired
	IEtudiantService etudiantService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	ICoursService coursService;

	@Autowired
	IEvaluationService evaluationService;

	@GetMapping("/etudiants")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}

	@GetMapping("/etudiants/{id}")
	public Etudiant findOne(@PathVariable Long id) {
		return etudiantService.findOne(id);
	}

	@DeleteMapping("/etudiants/{id}")
	public void deleteEtudiant(@PathVariable Long id) {
		etudiantService.delete(id);
	}

	@PostMapping("/etudiants")
	public Etudiant saveEtudiant(@RequestParam(required = false) String nom,
			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email,
			@RequestParam(required = false) Date dateNaissance, @RequestParam(required = false) MultipartFile photo,
			@RequestParam(required = false) Double moyenne, @RequestParam(required = false) Set<Role> roles,
			@RequestParam(required = false) Set<Cours> courss) {
		try {
			Etudiant currentEtudiant = new Etudiant();
			currentEtudiant.setNomPersonne(nom);
			currentEtudiant.setPrenomPersonne(prenom);
			currentEtudiant.setUsername(username);
			currentEtudiant.setPassword(passwordEncoder.encode(password));
			currentEtudiant.setEmail(email);
			currentEtudiant.setDateNaissancePersonne(dateNaissance);
			if (photo != null) {
				currentEtudiant.setPhotoProfil(photo.getBytes());
			}
			currentEtudiant.setMoyenne(moyenne);
			currentEtudiant.setRoles(roles);
			currentEtudiant.setCourss(courss);
			return etudiantService.save(currentEtudiant);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@PutMapping("/etudiants/{id}")
	public String updateEtudiant(@PathVariable Long id, @RequestParam(required = false) String nom,
			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email,
			@RequestParam(required = false) Date dateNaissance, @RequestParam(required = false) MultipartFile photo,
			@RequestParam(required = false) Double moyenne, @RequestParam(required = false) Set<Role> roles,
			@RequestParam(required = false) Set<Cours> courss) {
		Etudiant currentEtudiant = etudiantService.findOne(id);
		try {
			currentEtudiant.setNomPersonne(nom);
			currentEtudiant.setPrenomPersonne(prenom);
			currentEtudiant.setUsername(username);
			currentEtudiant.setPassword(passwordEncoder.encode(password));
			currentEtudiant.setEmail(email);
			currentEtudiant.setDateNaissancePersonne(dateNaissance);
			if (photo != null) {
				currentEtudiant.setPhotoProfil(photo.getBytes());
			}
			currentEtudiant.setMoyenne(moyenne);
			currentEtudiant.setRoles(roles);
			currentEtudiant.setCourss(courss);
			etudiantService.save(currentEtudiant);
			return "updated";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "failed";
		}
	}

	@GetMapping("/etudiants/cours")
	public List<Cours> afficherCours(@RequestParam(required = false) String id) {
		if (id == null) {
			return coursService.findAll();
		} else {
			return coursService.findByCours(id);
		}
	}

	/* Ne marche pas pb : cle etrangere */
	@PostMapping("/etudiants/cours/evaluations") // => /etudiants/cours/evaluations?commentaire=truc&?...
	public String evaluerCours(@RequestParam(required=false) String commentaire,@RequestParam(required=false) String note_cours,@RequestParam(required=false) String id_cours) {
		try {
			evaluationService.evaluerCours(commentaire, note_cours, id_cours);
			return "OK";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "PAS OK";
		}
	}

}
