package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long>{
	
	Cours findByNomCours(String nomCours);
	
	public String commandeSQL = "SELECT * from cours WHERE id_cours IN (SELECT id_cours from lecture WHERE id_personne =?1)";
	@Query(value = commandeSQL, nativeQuery = true)
    List<Cours> listCours(String idClasse);
}
