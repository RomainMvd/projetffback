package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Distanciel;

public interface IDistancielService {
	
	List<Distanciel> findAll();

	Distanciel findOne(Long idDistanciel);

	Distanciel save(Distanciel distanciel);

	void delete(Long idDistanciel);
}
