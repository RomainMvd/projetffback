package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Evaluation;

public interface IEvaluationService {

	List<Evaluation> findAll();

	Evaluation findOne(Long idEvaluation);

	Evaluation save(Evaluation evaluation);

	void delete(Long idEvaluation);

	List<Evaluation> listCommentaires(String idEvaluation);

	// Evaluation commenter(String commentaire, Double note_cours, Integer id_cours);
}
