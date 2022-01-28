package com.inti.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entities.Candidat;
import com.inti.service.interfaces.ICandidatService;

@RestController
@CrossOrigin
@RequestMapping("/candidats")
public class CandidatController {

	@Autowired
	ICandidatService candidatService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping()
	public List<Candidat> afficherCandidats(@RequestParam(required = false) String t) {
		return candidatService.findAll();
	}
	
	@GetMapping("/{id}")
	public Candidat afficherCandidat(@PathVariable Long id) {
		return candidatService.findOne(id);
	}
	
	@PostMapping()
	public Candidat saveCandidat(@RequestParam(required = false) String nom,
			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email,
			@RequestParam(required = false) String dateNaissance, @RequestParam(required = false) MultipartFile photo,
			 @RequestParam(required = false) MultipartFile lm,  @RequestParam(required = false) MultipartFile cv,
			 @RequestParam(required = false) String poste) {
		try {
			Candidat currentCandidat = new Candidat();
			currentCandidat.setNomPersonne(nom);
			currentCandidat.setPrenomPersonne(prenom);
			currentCandidat.setUsername(username);
			currentCandidat.setPassword(passwordEncoder.encode(password));
			currentCandidat.setEmail(email);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissance);
			currentCandidat.setDateNaissancePersonne(date);
			if (photo != null) {
				currentCandidat.setPhotoProfil(photo.getBytes());
			}
			if (lm != null) {
				currentCandidat.setPhotoProfil(lm.getBytes());
			}
			if (cv != null) {
				currentCandidat.setPhotoProfil(cv.getBytes());
			}
			currentCandidat.setPosteConvoite(poste);
			return candidatService.save(currentCandidat);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@PutMapping("/{id}")
	public Candidat updateCandidat(@PathVariable Long id,@RequestParam(required = false) String nom,
			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email,
			@RequestParam(required = false) String dateNaissance, @RequestParam(required = false) MultipartFile photo,
			 @RequestParam(required = false) MultipartFile lm,  @RequestParam(required = false) MultipartFile cv,
			 @RequestParam(required = false) String poste) {
		Candidat currentCandidat = candidatService.findOne(id);
		try {
			currentCandidat.setNomPersonne(nom);
			currentCandidat.setPrenomPersonne(prenom);
			currentCandidat.setUsername(username);
			currentCandidat.setPassword(passwordEncoder.encode(password));
			currentCandidat.setEmail(email);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissance);
			currentCandidat.setDateNaissancePersonne(date);
			if (photo != null) {
				currentCandidat.setPhotoProfil(photo.getBytes());
			}
			if (lm != null) {
				currentCandidat.setPhotoProfil(lm.getBytes());
			}
			if (cv != null) {
				currentCandidat.setPhotoProfil(cv.getBytes());
			}
			currentCandidat.setPosteConvoite(poste);
			return candidatService.save(currentCandidat);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteCandidat(@PathVariable Long id) {
		candidatService.delete(id);
	}
}
