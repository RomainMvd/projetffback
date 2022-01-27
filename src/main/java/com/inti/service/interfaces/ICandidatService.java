package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Candidat;

public interface ICandidatService {

	Candidat findOne(Long idCandidat);

	Candidat save(Candidat personne);

	void delete(Long idCandidat);

	List<Candidat> findAll();
}
