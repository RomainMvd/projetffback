package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Correction;

public interface ICorrectionService {
	
	List<Correction> findAll();

	Correction findOne(Long idCorrection);

	Correction save(Correction correction);

	void delete(Long idCorrection);
}
