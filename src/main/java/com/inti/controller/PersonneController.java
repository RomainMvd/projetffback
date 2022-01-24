package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Personne;
import com.inti.service.interfaces.IClasseService;
import com.inti.service.interfaces.IPersonneService;

@RestController
@CrossOrigin
public class PersonneController {

	@Autowired
	IPersonneService personneService;
	
	@GetMapping("/personnes")
	public List<Personne> findAll() {
		return personneService.findAll();
	}
	
	@GetMapping("/personnes/{id}")
	public Personne findOne(@PathVariable Long id) {
		return personneService.findOne(id);
	}
	
	@DeleteMapping("/personnes/{id}")
	public void deletePersonne(@PathVariable Long id) {
		personneService.delete(id);
	}
	
	// TEST
//	
//	@Autowired
//	IClasseService classeService;
//	/*
//	 * Méthode utilisé pour afficher les personnes se trouvant dans la classe nommé name
//	 */
//	@GetMapping("/personnes/classes")
//	public List<Personne> listPersonnesClasse(@RequestParam String name) {
//		// GET ID THROUGH NAME
//		Long id = classeService.getIdByName(name);
//		return personneService.listPersonnesClasses(id.toString());
//	}
}
