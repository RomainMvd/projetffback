package com.inti.service.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.inti.entities.Classe;

public interface IClasseService {

	List<Classe> findAll();

	Classe findOne(Long idClasse);

	Classe save(Classe classe);

	void delete(Long idClasse);
	
	List<Classe> findAllTriNomClasse();
	
	List<Classe> afficherClassesPersonne(String idP);
	
	List<Classe> afficherClassesPersonneType(String type);
	
	List<Classe> afficherClassesCours(String idC);
	
	List<Classe> afficherClassesEnseignantAdmin(String idE);
	
	Classe findByNomClasse(String nomClasse);
}
