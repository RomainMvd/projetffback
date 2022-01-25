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

	public String commandeSQL2 = "INSERT INTO evaluation(commentaire, note_cours, id_cours) values(?1, ?2, ?3);";

	@Modifying
	@Transactional
	@Query(value = commandeSQL2, nativeQuery = true)
	void evaluerCours(String commentaire, String note_cours, String id_cours);

	public String commandeSQL3 = "UPDATE evaluation SET commentaire = ?1, id_cours = ?2, note_cours= ?3 where id_evaluation = ?4;";

	@Modifying
	@Transactional
	@Query(value = commandeSQL3, nativeQuery = true)
	String updateCommentaire(String commentaire, String note_cours, String id_cours, String id_evaluation);
}
