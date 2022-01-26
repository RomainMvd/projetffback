package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Classe;
import com.inti.repositories.ClasseRepository;
import com.inti.service.interfaces.IClasseService;

@Service
public class ClasseService implements IClasseService{

	@Autowired
	ClasseRepository classeRepository;

	@Override
	public List<Classe> findAll() {
		return classeRepository.findAll();
	}

	@Override
	public Classe findOne(Long idClasse) {
		return classeRepository.findById(idClasse).get();
	}

	@Override
	public Classe save(Classe classe) {
		return classeRepository.save(classe);
	}

	@Override
	public void delete(Long idClasse) {
		classeRepository.deleteById(idClasse);
		
	}

	@Override
	public Classe findByNomClasse(String nomClasse) {
		return classeRepository.findByNomClasse(nomClasse);
	}

	@Override
	public List<Classe> findAllTriNomClasse() {
		return classeRepository.findAllTriNomClasse();
	}

	@Override
	public List<Classe> afficherClassesPersonne(String idP) {
		return classeRepository.afficherClassesPersonne(idP);
	}

	@Override
	public List<Classe> afficherClassesPersonneType(String type) {
		return classeRepository.afficherClassesPersonneType(type);
	}

	@Override
	public List<Classe> afficherClassesCours(String idC) {
		return classeRepository.afficherClassesCours(idC);
	}

	@Override
	public List<Classe> afficherClassesEnseignantAdmin(String idE) {
		return classeRepository.afficherClassesEnseignantAdmin(idE);
	}

	

}
