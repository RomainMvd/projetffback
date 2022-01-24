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
import com.inti.entities.Enseignant;
import com.inti.entities.Role;
import com.inti.service.interfaces.IEnseignantService;

@RestController
@CrossOrigin
public class EnseignantController {

	@Autowired
	IEnseignantService enseignantService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/enseignants")
	public List<Enseignant> findAll() {
		return enseignantService.findAll();
	}

	@GetMapping("/enseignants/{id}")
	public Enseignant findOne(@PathVariable Long id) {
		return enseignantService.findOne(id);
	}

	@DeleteMapping("/enseignants/{id}")
	public void deleteEnseignant(@PathVariable Long id) {
		enseignantService.delete(id);
	}

	@PostMapping("/enseignants")
	public Enseignant saveEnseignant(@RequestParam(required = false) String nom,
			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email,
			@RequestParam(required = false) Date dateNaissance, @RequestParam(required = false) MultipartFile photo,
			@RequestParam(required = false) Double salaire, @RequestParam(required = false) Set<Role> roles,
			@RequestParam(required = false) Set<Cours> courss) {
		try {
			Enseignant currentEnseignant = new Enseignant();
			currentEnseignant.setNomPersonne(nom);
			currentEnseignant.setPrenomPersonne(prenom);
			currentEnseignant.setUsername(username);
			currentEnseignant.setPassword(passwordEncoder.encode(password));
			currentEnseignant.setEmail(email);
			currentEnseignant.setDateNaissancePersonne(dateNaissance);
			if (photo != null) {
				currentEnseignant.setPhotoProfil(photo.getBytes());
			}
			currentEnseignant.setSalaire(salaire);
			currentEnseignant.setRoles(roles);
			currentEnseignant.setCourss(courss);
			return enseignantService.save(currentEnseignant);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@PutMapping("/enseignants/{id}")
	public String updateEnseignant(@PathVariable Long id,
			@RequestParam(required = false) String nom,
			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email,
			@RequestParam(required = false) Date dateNaissance, @RequestParam(required = false) MultipartFile photo,
			@RequestParam(required = false) Double salaire, @RequestParam(required = false) Set<Role> roles,
			@RequestParam(required = false) Set<Cours> courss) {
		Enseignant currentEnseignant= enseignantService.findOne(id);
		try {
			currentEnseignant.setNomPersonne(nom);
			currentEnseignant.setPrenomPersonne(prenom);
			currentEnseignant.setUsername(username);
			currentEnseignant.setPassword(passwordEncoder.encode(password));
			currentEnseignant.setEmail(email);
			currentEnseignant.setDateNaissancePersonne(dateNaissance);
			if (photo != null) {
				currentEnseignant.setPhotoProfil(photo.getBytes());
			}
			currentEnseignant.setSalaire(salaire);
			currentEnseignant.setRoles(roles);
			currentEnseignant.setCourss(courss);
			enseignantService.save(currentEnseignant);
			return "updated";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "failed";
		}
	}
	
}
