package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Evaluation;
import com.inti.repositories.EvaluationRepository;
import com.inti.service.interfaces.IEvaluationService;

@Service
public class EvaluationService implements IEvaluationService {

	@Autowired
	EvaluationRepository evaluationRepository;

	@Override
	public List<Evaluation> findAll() {
		return evaluationRepository.findAll();
	}

	@Override
	public Evaluation findOne(Long idEvaluation) {
		return evaluationRepository.findById(idEvaluation).get();
	}

	@Override
	public Evaluation save(Evaluation evaluation) {
		return evaluationRepository.save(evaluation);
	}

	@Override
	public void delete(Long idEvaluation) {
		evaluationRepository.deleteById(idEvaluation);

	}

	@Override
	public List<Evaluation> listCommentaires(String idEvaluation) {

		return evaluationRepository.listCommentaires(idEvaluation);
	}

	@Override
	public void evaluerCours(String commentaire, String note_cours, String id_cours) {

	}

	@Override
	public String updateCommentaire(String commentaire, String note_cours, String id_cours, String id_evaluation) {
		return evaluationRepository.updateCommentaire(commentaire, note_cours, id_cours, id_evaluation);
	}

}
