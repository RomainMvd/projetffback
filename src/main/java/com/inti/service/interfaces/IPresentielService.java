package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Presentiel;

public interface IPresentielService {
	
	List<Presentiel> findAll();

	Presentiel findOne(Long idPresentiel);

	Presentiel save(Presentiel presentiel);

	void delete(Long idPresentiel);
}
