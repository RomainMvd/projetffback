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
	public Cours findByNomCours(String nomCours) {
		return coursRepository.findByNomCours(nomCours);
	}

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
	public List<Cours> findByCours(Long id) {
		
		return coursRepository.listCours(id);
	}
}
