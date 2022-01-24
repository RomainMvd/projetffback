package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Distanciel;
import com.inti.repositories.DistancielRepository;
import com.inti.service.interfaces.IDistancielService;

@Service
public class DistancielService implements IDistancielService{
	
	@Autowired
	DistancielRepository distancielRepository;

	@Override
	public List<Distanciel> findAll() {
		return distancielRepository.findAll();
	}

	@Override
	public Distanciel findOne(Long idDistanciel) {
		return distancielRepository.findById(idDistanciel).get();
	}

	@Override
	public Distanciel save(Distanciel distanciel) {
		return distancielRepository.save(distanciel);
	}

	@Override
	public void delete(Long idDistanciel) {
		distancielRepository.deleteById(idDistanciel);
		
	}

}
