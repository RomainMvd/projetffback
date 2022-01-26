package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Cours;
import com.inti.repositories.CoursRepository;
import com.inti.service.interfaces.ICoursService;

@Service
public class CoursService implements ICoursService{
	
	@Autowired
	CoursRepository coursRepository;

	@Override
	public List<Cours> findAll() {
		return coursRepository.findAll();
	}

	@Override
	public Cours findOne(Long idCours) {
		return coursRepository.findById(idCours).get();
	}

	@Override
	public Cours save(Cours cours) {
		return coursRepository.save(cours);
	}

	@Override
	public void delete(Long idCours) {
		coursRepository.deleteById(idCours);
		
	}

	@Override
	public List<Cours> findAllTriCoursType() {
		return coursRepository.findAllTriCoursType();
	}

	@Override
	public List<Cours> findAllTriNomCours() {
		return coursRepository.findAllTriNomCours();
	}

	@Override
	public List<Cours> findAllTriNomMatiere() {
		return coursRepository.findAllTriNomMatiere();
	}

	@Override
	public List<Cours> findAllTriNbrHeure() {
		return coursRepository.findAllTriNbrHeure();
	}

	@Override
	public List<Cours> afficherCoursCoursType(String cType) {
		return coursRepository.afficherCoursCoursType(cType);
	}

	@Override
	public List<Cours> afficherCoursNomMatiere(String nMatiere) {
		return coursRepository.afficherCoursNomMatiere(nMatiere);
	}

	@Override
	public List<Cours> afficherCoursClasseEtudiants(String idC) {
		return coursRepository.afficherCoursClasseEtudiants(idC);
	}

	@Override
	public List<Cours> afficherCoursClasse(String idC) {
		return coursRepository.afficherCoursClasse(idC);
	}

	@Override
	public List<Cours> afficherCoursPersonne(String idP) {
		return coursRepository.afficherCoursPersonne(idP);
	}

	@Override
	public List<Cours> afficherCoursPersonnesType(String type) {
		return coursRepository.afficherCoursPersonnesType(type);
	}

	@Override
	public List<Cours> afficherCoursEnseignantsAdmin(String idR) {
		return coursRepository.afficherCoursEnseignantsAdmin(idR);
	}

	@Override
	public List<Cours> afficherCoursEnseignantAdmin(String idR, String idE) {
		return coursRepository.afficherCoursEnseignantAdmin(idR, idE);
	}
	
	

	
}
