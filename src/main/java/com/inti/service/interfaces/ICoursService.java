package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Cours;

public interface ICoursService {

	Cours findByNomCours(String nomCours);
	
	List<Cours> findAll();

	Cours findOne(Long idCours);

	Cours save(Cours cours);

	void delete(Long idCours);

	List<Cours> findByCours(String idCours);

	Cours insererCours(String idCours, String idPersonne,String fichierCours);

	Cours updaterCours(String idCours, String idPersonne, String fichierCours);
	
}
