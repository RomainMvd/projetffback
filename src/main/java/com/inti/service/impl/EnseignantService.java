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

}
