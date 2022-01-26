package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{

	// USELESS ?
	Enseignant findByUsername(String username);
	
	@Query(value = "select * from personne where personne_type='enseignant' and id_personne order by salaire",  nativeQuery = true)
	List<Enseignant> findAllTri();
	
	@Query(value="select * from personne where personne_type='enseignant' and id_personne IN (select id_personne from personne_classe where id_classe=?1)", nativeQuery = true)
	List<Enseignant> afficherEnseignantsClasse(String idC);
	
	@Query(value = "select * from personne where personne_type='enseignant' and id_personne IN (select id_personne from personne_classe where id_classe=?1) and id_personne IN (select id_personne from profil where id_role=?2)", nativeQuery = true)
	List<Enseignant> afficherEnseignantsAdminClasse(String idC, String idR);
	
	@Query(value="select * from personne where personne_type='enseignant' and id_personne IN (select id_personne from lecture where id_cours=?1)", nativeQuery = true)
	List<Enseignant> afficherEnseignantsCours(String idC);
	
	@Query(value="select * from personne where personne_type='enseignant' and id_personne IN (select id_personne from lecture where id_cours=?1) and id_personne IN (select id_personne from profil where id_role=?2)", nativeQuery = true)
	List<Enseignant> afficherEnseignantsAdminCours(String idC, String idR);
	
	@Query(value = "select * from personne where personne_type='enseignant' and id_personne IN (select id_personne from profil where id_role=?1)", nativeQuery = true)
	List<Enseignant> afficherEnseignantsAdmin(String idR);
	
	@Query(value="select * from personne where personne_type='enseignant' and id_personne IN (select id_personne from lecture where id_cours IN (select id_cours from lecture where id_personne=?1))", nativeQuery = true)
	List<Enseignant> afficherEnseignantsEtudiant(String idEtudiant);
	
	@Query(value="select * from personne where personne_type='enseignant' and id_personne IN (select id_personne from lecture where id_cours IN (select id_cours from lecture where id_personne=?1)) and id_personne IN (select id_personne from profil where id_role=?2)", nativeQuery = true)
	List<Enseignant> afficherEnseignantsAdminEtudiant(String idEtudiant, String idR);
	
	@Query(value="select * from personne where id_personne=?2 and personne_type='enseignant' and id_personne IN (select id_personne from personne_classe where id_classe=?1)", nativeQuery = true)
	Enseignant afficherEnseignantClasse(String idC, String idE);
	
	@Query(value = "select * from personne where id_personne=?3 and personne_type='enseignant' and id_personne IN (select id_personne from personne_classe where id_classe=?1) and id_personne IN (select id_personne from profil where id_role=?2)", nativeQuery = true)
	Enseignant afficherEnseignantAdminClasse(String idC, String idR, String idE);
	
	@Query(value="select * from personne where id_personne=?2 and personne_type='enseignant' and id_personne IN (select id_personne from lecture where id_cours=?1)", nativeQuery = true)
	Enseignant afficherEnseignantCours(String idC, String idE);
	
	@Query(value="select * from personne where id_personne=?3 and personne_type='enseignant' and id_personne IN (select id_personne from lecture where id_cours=?1) and id_personne IN (select id_personne from profil where id_role=?2)", nativeQuery = true)
	Enseignant afficherEnseignantAdminCours(String idC, String idR, String idE);
	
	@Query(value = "select * from personne where id_personne=?2 and personne_type='enseignant' and id_personne IN (select id_personne from profil where id_role=?1)", nativeQuery = true)
	Enseignant afficherEnseignantAdmin(String idR, String idE);
	
	@Query(value="select * from personne where id_personne=?2 and personne_type='enseignant' and id_personne IN (select id_personne from lecture where id_cours IN (select id_cours from lecture where id_personne=?1))", nativeQuery = true)
	Enseignant afficherEnseignantEtudiant(String idEtudiant, String idEnseignant);
	
	@Query(value="select * from personne where id_personne=?3 and personne_type='enseignant' and id_personne IN (select id_personne from lecture where id_cours IN (select id_cours from lecture where id_personne=?1)) and id_personne IN (select id_personne from profil where id_role=?2)", nativeQuery = true)
	Enseignant afficherEnseignantAdminEtudiant(String idEtudiant, String idR, String idEnseignant);
	
	@Query(value="select * from personne where personne_type='enseignant' where id_personne IN (select id_personne from personne_classe where id_classe=?1) and id_personne IN (select id_personne from lecture where id_cours=?2", nativeQuery = true)
	List<Enseignant> afficherEnseignantsClasseCours(String idClasse, String idCours);
	
//	public String commandeSQL = "SELECT * from personne where id_personne IN (SELECT id_personne FROM personne_classe WHERE id_classe =?1) AND personne_type='enseignant'";
//	@Query(value = commandeSQL, nativeQuery = true)
//	List<Enseignant> listEnseignantsClasses(String idClasse);
	

}
