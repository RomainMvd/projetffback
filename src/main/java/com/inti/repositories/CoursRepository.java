package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long>{
	
	Cours findByNomCours(String nomCours);
}
