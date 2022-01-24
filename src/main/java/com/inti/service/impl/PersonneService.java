package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Classe;
import com.inti.entities.Personne;
import com.inti.repositories.PersonneRepository;
import com.inti.service.interfaces.IPersonneService;

@Service
public class PersonneService implements IPersonneService{

	@Autowired
	PersonneRepository<Personne> personneRepository;

	@Override
	public List<Personne> listPersonnesClasses(String idClasse) {
		return personneRepository.listPersonnesClasses(idClasse);
	}

	@Override
	public Personne findByUsername(String username) {
		return personneRepository.findByUsername(username);
	}

	@Override
	public List<Personne> findAll() {
		return personneRepository.findAll();
	}

	@Override
	public Personne findOne(Long idPersonne) {
		return personneRepository.findById(idPersonne).get();
	}

	@Override
	public Personne save(Personne personne) {
		return personneRepository.save(personne);
	}

	@Override
	public void delete(Long idPersonne) {
		personneRepository.deleteById(idPersonne);
		
	}

	@Override
	public List<Personne> listPersonnesClasseType(String idClasse, String type) {
		return personneRepository.listPersonnesClasseType(idClasse, type);
	}


}
