package com.inti.service.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.inti.entities.Etudiant;

public interface IEtudiantService {

	Etudiant findOne(Long idEtudiant);

	Etudiant save(Etudiant personne);

	void delete(Long idEtudiant);

	Etudiant findByUsername(String username);

	List<Etudiant> findAll();

	List<Etudiant> findAllTri();
	
	List<Etudiant> findByOrderByMoyenneAsc();

	List<Etudiant> afficherEtudiantsClasse(String idC);

	List<Etudiant> afficherEtudiantsClasseTri(String idC);

	Etudiant afficherEtudiantClasse(String idC, String idE);

	List<Etudiant> afficherEtudiantsCours(String idC);

	List<Etudiant> afficherEtudiantsCoursTri(String idC);

	Etudiant afficherEtudiantCours(String idC, String idE);

	List<Etudiant> afficherEtudiantsEnseignant(String idEnseignant);

	List<Etudiant> afficherEtudiantsEnseignantTri(String idEnseignant);

	Etudiant afficherEtudiantEnseignant(String idEnseignant, String idEtudiant);
}
