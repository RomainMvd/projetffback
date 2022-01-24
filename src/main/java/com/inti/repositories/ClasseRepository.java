package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Classe;
import com.inti.entities.Personne;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
	
	Classe findByNomClasse(String nomClasse);
	
	/*
	 * Repository utilisé pour déterminer l'id en fonction du nom de la classe
	 * utilisé dans PersonneController
	 */
	public String commandeSQL = "SELECT id_classe from classe where nom_classe=?1";
	@Query(value = commandeSQL, nativeQuery = true)
	Long getIdByName(String nomClasse);
	
	@Query(nativeQuery = true, value = "select * from classe where id_classe IN (select id_classe from personne_classe where id_personne IN (select id_personne from lecture"
			+ " where id_cours=?1))")
	List<Classe> getClasseByIdCours(String id); 
	
}
