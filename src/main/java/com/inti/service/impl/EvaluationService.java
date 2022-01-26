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
	public List<Evaluation> listCommentaires(String idCours) {

		return evaluationRepository.listCommentaires(idCours);
	}

	@Override
	public Integer evaluerCours(String commentaire, String note_cours, String id_cours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateCommentaire(String commentaire, String note_cours, String id_cours, String id_evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Integer evaluerCours(String commentaire, String note_cours, String id_cours) {
//<<<<<<< HEAD
//		return evaluationRepository.evaluerCours(commentaire, note_cours, id_cours);
//
//	}
//
//	@Override
//	public Integer updateCommentaire(String commentaire, String note_cours, String id_cours, String id_evaluation) {
//=======
//		
//		return evaluationRepository.evaluerCours(commentaire, note_cours, id_cours);
//	}
//
//	@Override
//	public Integer updateCommentaire(String commentaire, String id_cours, String note_cours, String id_evaluation) {
//		System.out.println(commentaire + id_cours + note_cours + id_evaluation);
//>>>>>>> localHenri
//		return evaluationRepository.updateCommentaire(commentaire, id_cours, note_cours, id_evaluation);
//	}

}
