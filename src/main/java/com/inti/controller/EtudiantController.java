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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entities.Cours;
import com.inti.entities.Etudiant;
import com.inti.entities.Role;
import com.inti.service.interfaces.IEtudiantService;

@RestController
@CrossOrigin
public class EtudiantController {

	@Autowired
	IEtudiantService etudiantService;

	@Autowired
	PasswordEncoder passwordEncoder;

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
	public String updateEtudiant(@PathVariable Long id,
			@RequestParam(required = false) String nom,
			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email,
			@RequestParam(required = false) Date dateNaissance, @RequestParam(required = false) MultipartFile photo,
			@RequestParam(required = false) Double moyenne, @RequestParam(required = false) Set<Role> roles,
			@RequestParam(required = false) Set<Cours> courss) {
		Etudiant currentEtudiant= etudiantService.findOne(id);
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
	
}
