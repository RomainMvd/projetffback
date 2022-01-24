package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Enseignant;

public interface IEnseignantService {

	List<Enseignant> findAll();

	Enseignant findOne(Long idEnseignant);

	Enseignant save(Enseignant personne);

	void delete(Long idEnseignant);
	
	Enseignant findByUsername(String username);
	
	//List<Enseignant> listEnseignantsClasses(String idClasse);
}
