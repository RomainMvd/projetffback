package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Enseignant;
import com.inti.repositories.EnseignantRepository;
import com.inti.service.interfaces.IEnseignantService;

@Service
public class EnseignantService implements IEnseignantService {

	@Autowired
	EnseignantRepository enseignantRepository;

	@Override
	public Enseignant findByUsername(String username) {
		return enseignantRepository.findByUsername(username);
	}

	@Override
	public List<Enseignant> findAll() {
		return enseignantRepository.findAll();
	}

	@Override
	public Enseignant findOne(Long idEnseignant) {
		return enseignantRepository.findById(idEnseignant).get();
	}

	@Override
	public Enseignant save(Enseignant enseignant) {
		return enseignantRepository.save(enseignant);
	}

	@Override
	public void delete(Long idEnseignant) {
		enseignantRepository.deleteById(idEnseignant);

	}

	@Override
	public List<Enseignant> findAllTri() {
		return enseignantRepository.findAllTri();
	}

	@Override
	public List<Enseignant> afficherEnseignantsClasse(String idC) {
		return enseignantRepository.afficherEnseignantsClasse(idC);
	}

	@Override
	public List<Enseignant> afficherEnseignantsAdminClasse(String idC, String idR) {
		return enseignantRepository.afficherEnseignantsAdminClasse(idC, idR);
	}

	@Override
	public List<Enseignant> afficherEnseignantsCours(String idC) {
		return enseignantRepository.afficherEnseignantsCours(idC);
	}

	@Override
	public List<Enseignant> afficherEnseignantsAdminCours(String idC, String idR) {
		return enseignantRepository.afficherEnseignantsAdminCours(idC, idR);
	}

	@Override
	public List<Enseignant> afficherEnseignantsAdmin(String idR) {
		return enseignantRepository.afficherEnseignantsAdmin(idR);
	}

	@Override
	public List<Enseignant> afficherEnseignantsEtudiant(String idEtudiant) {
		return enseignantRepository.afficherEnseignantsEtudiant(idEtudiant);
	}

	@Override
	public List<Enseignant> afficherEnseignantsAdminEtudiant(String idEtudiant, String idR) {
		return enseignantRepository.afficherEnseignantsAdminEtudiant(idEtudiant, idR);
	}

	@Override
	public Enseignant afficherEnseignantClasse(String idC, String idE) {
		return enseignantRepository.afficherEnseignantClasse(idC, idE);
	}

	@Override
	public Enseignant afficherEnseignantAdminClasse(String idC, String idR, String idE) {
		return enseignantRepository.afficherEnseignantAdminClasse(idC, idR, idE);
	}

	@Override
	public Enseignant afficherEnseignantCours(String idC, String idE) {
		return enseignantRepository.afficherEnseignantCours(idC, idE);
	}

	@Override
	public Enseignant afficherEnseignantAdminCours(String idC, String idR, String idE) {
		return enseignantRepository.afficherEnseignantAdminCours(idC, idR, idE);
	}

	@Override
	public Enseignant afficherEnseignantAdmin(String idR, String idE) {
		return enseignantRepository.afficherEnseignantAdmin(idR, idE);
	}

	@Override
	public Enseignant afficherEnseignantEtudiant(String idEtudiant, String idEnseignant) {
		return enseignantRepository.afficherEnseignantEtudiant(idEtudiant, idEnseignant);
	}

	@Override
	public Enseignant afficherEnseignantAdminEtudiant(String idEtudiant, String idR, String idEnseignant) {
		return enseignantRepository.afficherEnseignantAdminEtudiant(idEtudiant, idR, idEnseignant);
	}

	@Override
	public List<Enseignant> afficherEnseignantsClasseCours(String idClasse, String idCours) {
		return enseignantRepository.afficherEnseignantsClasseCours(idClasse, idCours);
	}

}
