package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Examen;
import com.inti.repositories.ExamenRepository;
import com.inti.service.interfaces.IExamenService;

@Service
public class ExamenService implements IExamenService{
	
	@Autowired
	ExamenRepository examenRepository;

	@Override
	public List<Examen> findAll() {
		return examenRepository.findAll();
	}

	@Override
	public Examen findOne(Long idExamen) {
		return examenRepository.findById(idExamen).get();
	}

	@Override
	public Examen save(Examen examen) {
		return examenRepository.save(examen);
	}

	@Override
	public void delete(Long idExamen) {
		examenRepository.deleteById(idExamen);
		
	}

	@Override
	public List<Examen> listReponsesEleves(String idExamen) {
		return examenRepository.listReponsesEleves(idExamen);
	}

	@Override
	public List<Examen> listExamen(String idExam) {
		
		return examenRepository.listExamen(idExam);
	}

	@Override
	public Examen insererExamen(String idExam, String idPersonne) {
		return examenRepository.insererExamen(idExam, idPersonne);
	}

	@Override
	public Examen updaterExamen(String idExam, String idPersonne) {
		return examenRepository.insererExamen(idExam, idPersonne);
	}

}
