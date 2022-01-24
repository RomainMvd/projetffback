package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Evaluation;

@Repository
public interface TestSQLRepository extends JpaRepository<Evaluation, Long> {

	public String commandeSQL = "select avg(note_cours) from evaluation where id_cours=?1";

	@Query(value = commandeSQL, nativeQuery = true)
	Double avgEvaluationCours(String id);

//	  # je veux afficher la moyenne global d'un enseignant 
//	# get id_enseignant -> get_cours -> get avg de avg de chaque cours 
//	# avg evaluation cours -> 
//	#select avg(note_cours) from evaluation where id_cours=3; select avg(note_cours) from evaluation where id_cours IN (3,4);

//	# je veux afficher la moyenne global d'un enseignant 
//	# get id_enseignant -> get_cours -> get avg de avg de chaque cours
//	# avg evaluation cours -> 
//	#select avg(note_cours) from evaluation where id_cours=3;
//	select avg(note_cours) from evaluation where id_cours IN (Select id_cours from lecture where id_personne = 3);

	@Query(nativeQuery = true, value = "select avg(note_cours) from evaluation where id_cours IN (Select id_cours from lecture where id_personne="
			+ "(select id_personne from personne where id_personne=?1 and personne_type='enseignant'))")
	Double avgEvaluationCoursEnseignant(String ide);
	
}
