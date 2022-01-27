package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Etudiant;
import com.inti.repositories.EtudiantRepository;
import com.inti.service.interfaces.IEtudiantService;

@Service
public class EtudiantService implements IEtudiantService {

	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	public Etudiant findByUsername(String username) {
		return etudiantRepository.findByUsername(username);
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantRepository.findAll();
	}
	
	@Override
	public List<Etudiant> findAllTri() {
		return etudiantRepository.findAllTri();
	}
	
	@Override
	public List<Etudiant> findByOrderByMoyenneAsc() {
		return etudiantRepository.findByOrderByMoyenneAsc();
	}

	@Override
	public Etudiant findOne(Long idEtudiant) {
		return etudiantRepository.findById(idEtudiant).get();
	}

	@Override
	public Etudiant save(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@Override
	public void delete(Long idEtudiant) {
		etudiantRepository.deleteById(idEtudiant);
  }

	@Override
	public List<Etudiant> afficherEtudiantsClasse(String idC) {
		return etudiantRepository.afficherEtudiantsClasse(idC);
	}
	
	@Override
	public List<Etudiant> afficherEtudiantsClasseTri(String idC) {
		return etudiantRepository.afficherEtudiantsClasseTri(idC);
	}

	@Override
	public Etudiant afficherEtudiantClasse(String idC, String idE) {
		return etudiantRepository.afficherEtudiantClasse(idC, idE);
	}

	@Override
	public List<Etudiant> afficherEtudiantsCours(String idC) {
		return etudiantRepository.afficherEtudiantsCours(idC);
	}

	@Override
	public List<Etudiant> afficherEtudiantsCoursTri(String idC) {
		return etudiantRepository.afficherEtudiantsCoursTri(idC);
	}

	@Override
	public Etudiant afficherEtudiantCours(String idC, String idE) {
		return etudiantRepository.afficherEtudiantCours(idC, idE);
	}

	@Override
	public List<Etudiant> afficherEtudiantsEnseignant(String idEnseignant) {
		return etudiantRepository.afficherEtudiantsEnseignant(idEnseignant);
	}

	@Override
	public List<Etudiant> afficherEtudiantsEnseignantTri (String idEnseignant) {
		return etudiantRepository.afficherEtudiantsEnseignantTri(idEnseignant);
	}

	@Override
	public Etudiant afficherEtudiantEnseignant(String idEnseignant, String idEtudiant) {
		return etudiantRepository.afficherEtudiantEnseignant(idEnseignant, idEtudiant);
	}

	
	


	


}
