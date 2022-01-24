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
	public Long getIdByName(String nomClasse) {
		return classeRepository.getIdByName(nomClasse);
	}

	@Override
	public List<Classe> getClasseByIdCours(String id) {
		return classeRepository.getClasseByIdCours(id);
	}

}
