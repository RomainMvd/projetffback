package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	// USELESS ?
	Etudiant findByUsername(String username);

	@Query(value = "SELECT * from personne where personne_type='etudiant' order by moyenne", nativeQuery = true)
	List<Etudiant> findAllTri();
	
	List<Etudiant> findByOrderByMoyenneAsc();
	
	@Query(value = "SELECT * from personne where id_personne IN (SELECT id_personne FROM personne_classe WHERE id_classe =?1) AND personne_type='etudiant'", nativeQuery = true)
	List<Etudiant> afficherEtudiantsClasse(String idC);
	
	@Query(value = "SELECT * from personne where id_personne IN (SELECT id_personne FROM personne_classe WHERE id_classe =?1) AND personne_type='etudiant' order by moyenne", nativeQuery = true)
	List<Etudiant> afficherEtudiantsClasseTri(String idC);
	
	@Query(value="select * from personne where id_personne IN (select id_personne from personne_classe where id_classe=?1 and id_personne=?2) and personne_type='etudiant'", nativeQuery=true)
	Etudiant afficherEtudiantClasse(String idC, String idE);
	
	@Query(value="select * from personne where id_personne IN (select id_personne from lecture where id_cours=?1) and personne_type='etudiant'", nativeQuery=true)
	List<Etudiant> afficherEtudiantsCours(String idC);
	
	@Query(value="select * from personne where id_personne IN (select id_personne from lecture where id_cours=?1) and personne_type='etudiant' order by moyenne", nativeQuery=true)
	List<Etudiant> afficherEtudiantsCoursTri(String idC);
	
	@Query(value="select * from personne where id_personne IN (select id_personne from lecture where id_cours=?1 and id_personne=?2) and personne_type='etudiant'", nativeQuery=true)
	Etudiant afficherEtudiantCours(String idC, String idE);
	
	@Query(value="select * from personne where id_personne IN (select id_personne from lecture where id_cours IN (select id_cours from lecture where id_personne=?1)) and personne_type='etudiant')", nativeQuery=true)
	List<Etudiant> afficherEtudiantsEnseignant(String idEnseignant);
	
	@Query(value="select * from personne where id_personne IN (select id_personne from lecture where id_cours IN (select id_cours from lecture where id_personne=?1)) and personne_type='etudiant') order by moyenne", nativeQuery=true)
	List<Etudiant> afficherEtudiantsEnseignantTri(String idEnseignant);
	
	@Query(value="select * from personne where id_personne IN (select id_personne from lecture where id_personne=?2 and id_cours IN (select id_cours from lecture where id_personne=?1)) and personne_type='etudiant') order by moyenne", nativeQuery=true)
	Etudiant afficherEtudiantEnseignant(String idEnseignant, String idEtudiant);
	
	
}
