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

//	@Override
//	public Evaluation commenter(String commentaire, Double note_cours, Integer id_cours) {
//		
//		return evaluationRepository.commentCours(commentaire, note_cours, id_cours);
//	}

}
