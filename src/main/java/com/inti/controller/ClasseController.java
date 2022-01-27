package com.inti.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Classe;
import com.inti.entities.Personne;
import com.inti.service.interfaces.IClasseService;

@RestController
@CrossOrigin
//@RequestMapping("/classes")
public class ClasseController {

	@Autowired
	IClasseService classeService;
	
	@GetMapping("/classes")
	public List<Classe> afficherClasses(@RequestParam(required = false) String t) {
		if (t != null) {
			return classeService.findAllTriNomClasse();
		}
		else {
			return classeService.findAll();
		}
	}
	
	@GetMapping("/classes/personne/{idP}")
	public List<Classe> afficherClassesPersonne(@PathVariable String idP) {
		return classeService.afficherClassesPersonne(idP);
	}
	
	@GetMapping("/classes/enseignant/{idE}")
	public List<Classe> afficherClassesEnseignantAdmin(@PathVariable String idE) {
		return classeService.afficherClassesEnseignantAdmin(idE);
	}
	
	@GetMapping("/classes/{id}")
	public Classe findOne(@PathVariable Long id) {
		return classeService.findOne(id);
	}
	
	@GetMapping("/classes/nc")
	public Classe afficherClasseNomClasse(@RequestParam String nc) {
		return classeService.findByNomClasse(nc);
	}
	
	@DeleteMapping("/classes/{id}")
	public void deleteClasse(@PathVariable Long id) {
		classeService.delete(id);
	}
	
	@PostMapping("/classes")
	public Classe saveClasse(@RequestParam(required = false) String name, @RequestParam(required = false) Set<Personne> personnes) {
		Classe currentClasse = new Classe();
		currentClasse.setNomClasse(name);
		currentClasse.setPersonnes(personnes);
		return classeService.save(currentClasse);
	}
	
	@PutMapping("/classes/{id}")
	public Classe updateClasse(@PathVariable Long id, @RequestBody Classe classe) {
		Classe currentClasse = classeService.findOne(id);
		currentClasse.setNomClasse(classe.getNomClasse());
		currentClasse.setPersonnes(classe.getPersonnes());
		return classeService.save(currentClasse);
	}

}
	
//	// TEST
//	
//	/*
//	 * Méthode pour afficher une liste contenant toutes les classes si aucun name de classe n'est fourni
//	 * sinon envoie une liste contenant une seule classe en fonction de son nom
//	 */
//	@GetMapping("/classes")
//	public List<Classe> getClasseByNomClasse(@RequestParam(required = false) String name) {
//		if (name != null) {
//			List<Classe> listClasse = new ArrayList<>();
//			listClasse.add(classeService.findByNomClasse(name));
//			return listClasse;
//		} else {
//			return classeService.findAll();
//		}
//	}
	
//	@GetMapping("/classes")
//	public ResponseEntity<?> displayClasses(@RequestParam(required = false) String name) {
//		if (name != null) {
//			return new ResponseEntity<>(displayClasseName(name), HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(displayAllClasse(), HttpStatus.OK);
//		}
//	}
//	
//	private ResponseEntity<Classe> displayClasseName(String name) {
//		return new ResponseEntity<>(classeService.findByNomClasse(name), HttpStatus.OK);
//	}
//	
//	private ResponseEntity<List<Classe>> displayAllClasse() {
//		return new ResponseEntity<>(classeService.findAll(),HttpStatus.OK);
//	}


