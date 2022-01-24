package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Etudiant;

public interface IEtudiantService {
	List<Etudiant> findAll();

	Etudiant findOne(Long idEtudiant);

	Etudiant save(Etudiant personne);

	void delete(Long idEtudiant);
	
	Etudiant findByUsername(String username);
	
	//List<Etudiant> listEtudiantsClasses(String idClasse);
}
