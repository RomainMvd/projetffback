package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Examen;

public interface IExamenService {

	List<Examen> findAll();

	Examen findOne(Long idExamen);

	Examen save(Examen examen);

	void delete(Long idExamen);

	List<Examen> listReponsesEleves(String idExamen);
	
	List<Examen> listExamen(String idExam);
}
