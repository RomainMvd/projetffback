package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

	// USELESS ?
	Etudiant findByUsername(String username);
	
	public String commandeSQL = "SELECT * from personne where id_personne IN (SELECT id_personne FROM personne_classe WHERE id_classe =?1) AND personne_type='etudiant'";
	@Query(value = commandeSQL, nativeQuery = true)
	List<Etudiant> listEtudiantsClasses(String idClasse);
}
