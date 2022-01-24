package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Etudiant;
import com.inti.repositories.EtudiantRepository;
import com.inti.service.interfaces.IEtudiantService;

@Service
public class EtudiantService implements IEtudiantService {

	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	public Etudiant findByUsername(String username) {
		return etudiantRepository.findByUsername(username);
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant findOne(Long idEtudiant) {
		return etudiantRepository.findById(idEtudiant).get();
	}

	@Override
	public Etudiant save(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@Override
	public void delete(Long idEtudiant) {
		etudiantRepository.deleteById(idEtudiant);

	}

}
