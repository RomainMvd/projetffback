package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Correction;

@Repository
public interface CorrectionRepository extends JpaRepository<Correction, Long>{
	
	public String commandeSQL = "SELECT note_examen FROM correction WHERE id_examen IN (SELECT id_examen FROM examen WHERE id_cours IN (SELECT id_cours from lecture WHERE id_cours=1) )";
	@Query(value = commandeSQL, nativeQuery = true)
	List<Correction> listnotesEleves(String idCorrection);
	
	
}
