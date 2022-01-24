package com.inti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Evaluation;
import com.inti.repositories.TestSQLRepository;
import com.inti.service.interfaces.ITestSQLService;

@Service
public class TestSQLService implements ITestSQLService{

	@Autowired
	TestSQLRepository testSQLRepository;
	
	@Override
	public Double avgEvaluationCours(String id) {
		return testSQLRepository.avgEvaluationCours(id);
	}

	@Override
	public Double avgEvaluationCoursEnseignant(String ide) {
		return testSQLRepository.avgEvaluationCoursEnseignant(ide);
	}

	
}
