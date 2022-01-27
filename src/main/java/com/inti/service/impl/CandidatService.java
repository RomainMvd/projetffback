package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Candidat;
import com.inti.repositories.CandidatRepository;
import com.inti.service.interfaces.ICandidatService;

@Service
public class CandidatService implements ICandidatService{

	@Autowired
	CandidatRepository candidatRepository;

	@Override
	public List<Candidat> findAll() {
		return candidatRepository.findAll();
	}

	@Override
	public Candidat findOne(Long idCandidat) {
		return candidatRepository.findById(idCandidat).get();
	}

	@Override
	public Candidat save(Candidat candidat) {
		return candidatRepository.save(candidat);
	}

	@Override
	public void delete(Long idCandidat) {
		candidatRepository.deleteById(idCandidat);
		
	}

}