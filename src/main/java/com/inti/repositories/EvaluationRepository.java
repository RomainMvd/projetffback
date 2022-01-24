package com.inti.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Evaluation;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

	public String commandeSQL1 = "SELECT commentaire FROM evaluation WHERE id_cours IN (SELECT id_cours from lecture WHERE id_cours=?1)";

	@Query(value = commandeSQL1, nativeQuery = true)
	List<Evaluation> listCommentaires(String idEvaluation);

//	public String commandeSQL2 = "INSERT INTO evaluation WHERE id_evaluation =?1 VALUES(?2, ?3, ?4)";
//
//	@Modifying
//	@Transactional
//	@Query(value = commandeSQL2, nativeQuery = true)
//	Evaluation commentCours(String commentaire, Double note_cours, Integer id_cours);

}
