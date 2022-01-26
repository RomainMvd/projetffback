package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long>{
	
	Cours findByNomCours(String nomCours);
	

	public String commandeSQL1 = "SELECT * from cours WHERE id_cours IN (SELECT id_cours from lecture WHERE id_personne =?1)";
	@Query(value = commandeSQL1, nativeQuery = true)
    List<Cours> listCours(String idCours);
	
	public String commandeSQL2 = "INSERT INTO fichier_cours from cours WHERE id_cours IN (SELECT id_cours from lecture where id_personne="
	+ "	(select id_personne from personne where id_personne=?1 and personne_type='enseignant')) Value(?1,?2,?3)";
	@Query(value = commandeSQL2, nativeQuery = true)
	Cours insererCours(String idCours, String idPersonne, String fichierCours);

	public String commandeSQL3 = "Update cours set fichier_cours=?3 from cours WHERE id_cours IN (SELECT id_cours from lecture where id_cours=?1 and id_personne="
			+ "	(select id_personne from personne where id_personne=?2 and personne_type='enseignant'))";
			@Query(value = commandeSQL3, nativeQuery = true)
			Cours updaterCours(String idCours, String idPersonne, String fichierCours);
}
