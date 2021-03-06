package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Evaluation;

public interface IEvaluationService {

	List<Evaluation> findAll();

	Evaluation findOne(Long idEvaluation);

	Evaluation save(Evaluation evaluation);

	void delete(Long idEvaluation);

	List<Evaluation> listCommentaires(String idCours);

	Integer evaluerCours(String commentaire, String note_cours, String id_cours);
	
	Integer updateCommentaire(String commentaire, String note_cours, String id_cours, String id_evaluation);


}
