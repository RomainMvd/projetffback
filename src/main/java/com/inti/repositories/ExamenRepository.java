package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.inti.entities.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long>{

	public String commandeSQL1 = "SELECT fichier_reponse_examen FROM examen WHERE id_cours IN (SELECT id_cours from lecture WHERE id_cours=?1)"; 
	@Query(value = commandeSQL1, nativeQuery = true)
	List<Examen> listReponsesEleves(String idExam);
	
	public String commandeSQL2 = "SELECT fichier_examen FROM examen WHERE id_cours IN (SELECT id_cours from lecture WHERE id_cours=?1)"; 
	@Query(value = commandeSQL2, nativeQuery = true)
	List<Examen> listExamen(String idExam);
	
	public String commandeSQL3= "INSERT INTO fichier_examen FROM examen WHERE id_cours IN (SELECT id_cours from lecture where id_personne="
			+ "(select id_personne from personne where id_personne=?1 and personne_type='enseignant')) Value(?1) ";
	@Query(value = commandeSQL3, nativeQuery = true)
	Examen insererExamen(String idExam, String idPersonne);
	
	
}
