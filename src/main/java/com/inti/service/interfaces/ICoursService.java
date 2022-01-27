package com.inti.service.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.inti.entities.Cours;

public interface ICoursService {
	
	List<Cours> findAll();

	Cours findOne(Long idCours);

	Cours save(Cours cours);

	void delete(Long idCours);

	List<Cours> findAllTriCoursType();
	
	List<Cours> findAllTriNomCours();
	
	List<Cours> findAllTriNomMatiere();
	
	List<Cours> findAllTriNbrHeure();
	
	List<Cours> afficherCoursCoursType(String cType);
	
	List<Cours> afficherCoursNomMatiere(String nMatiere);
	
	// useless ?
	List<Cours> afficherCoursClasseEtudiants(String idC);
	
	List<Cours> afficherCoursClasse(String idC);
	
	List<Cours> afficherCoursClasseAll(String idC);
	
	List<Cours> afficherCoursPersonne(String idP);
	
	List<Cours> afficherCoursPersonnesType(String type);
	
	List<Cours> afficherCoursEnseignantsAdmin(String idR);
	
	List<Cours> afficherCoursEnseignantAdmin(String idR, String idE);
	
}
