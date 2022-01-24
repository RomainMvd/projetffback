package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Personne;

public interface IPersonneService {
	List<Personne> findAll();

	Personne findOne(Long idPersonne);

	Personne save(Personne personne);

	void delete(Long idPersonne);
	
	List<Personne> listPersonnesClasses(String idClasse);
	
	Personne findByUsername(String username);
	
	List<Personne> listPersonnesClasseType(String idClasse, String type);
}
