package com.inti.service.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.inti.entities.Enseignant;

public interface IEnseignantService {

	List<Enseignant> findAll();

	Enseignant findOne(Long idEnseignant);

	Enseignant save(Enseignant personne);

	void delete(Long idEnseignant);
	
	Enseignant findByUsername(String username);
	
	
	List<Enseignant> findAllTri();
	
	List<Enseignant> afficherEnseignantsClasse(String idC);
	
	List<Enseignant> afficherEnseignantsAdminClasse(String idC, String idR);
	
	List<Enseignant> afficherEnseignantsCours(String idC);
	
	List<Enseignant> afficherEnseignantsAdminCours(String idC, String idR);
	
	List<Enseignant> afficherEnseignantsAdmin(String idR);
	
	List<Enseignant> afficherEnseignantsEtudiant(String idEtudiant);
	
	List<Enseignant> afficherEnseignantsAdminEtudiant(String idEtudiant, String idR);
	
	Enseignant afficherEnseignantClasse(String idC, String idE);
	
	Enseignant afficherEnseignantAdminClasse(String idC, String idR, String idE);
	
	Enseignant afficherEnseignantCours(String idC, String idE);
	
	Enseignant afficherEnseignantAdminCours(String idC, String idR, String idE);
	
	Enseignant afficherEnseignantAdmin(String idR, String idE);
	
	Enseignant afficherEnseignantEtudiant(String idEtudiant, String idEnseignant);
	
	Enseignant afficherEnseignantAdminEtudiant(String idEtudiant, String idR, String idEnseignant);
	
	List<Enseignant> afficherEnseignantsClasseCours(String idClasse, String idCours);
}
