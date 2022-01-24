package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Presentiel;
import com.inti.repositories.PresentielRepository;
import com.inti.service.interfaces.IPresentielService;

@Service
public class PresentielService implements IPresentielService{
	
	@Autowired
	PresentielRepository presentielRepository;

	@Override
	public List<Presentiel> findAll() {
		return presentielRepository.findAll();
	}

	@Override
	public Presentiel findOne(Long idPresentiel) {
		return presentielRepository.findById(idPresentiel).get();
	}

	@Override
	public Presentiel save(Presentiel presentiel) {
		return presentielRepository.save(presentiel);
	}

	@Override
	public void delete(Long idPresentiel) {
		presentielRepository.deleteById(idPresentiel);
		
	}

}
