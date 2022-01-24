package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Personne;

@Repository
public interface PersonneRepository<T extends Personne> extends JpaRepository<T, Long>{
	
	Personne findByUsername(String username);
	
	public String commandeSQL = "SELECT * from personne where id_personne IN (SELECT id_personne FROM personne_classe WHERE id_classe =?1)";
	@Query(value = commandeSQL, nativeQuery = true)
	List<Personne> listPersonnesClasses(String idClasse);
	
}
