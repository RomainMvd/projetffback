package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long>{
	
	Cours findByNomCours(String nomCours);
	
	@Query(value = "select * from cours order by cours_type", nativeQuery = true)
	List<Cours> findAllTriCoursType();
	
	@Query(value = "select * from cours order by nom_cours", nativeQuery = true)
	List<Cours> findAllTriNomCours();
	
	@Query(value = "select * from cours order by nom_matiere", nativeQuery = true)
	List<Cours> findAllTriNomMatiere();
	
	@Query(value = "select * from cours order by nbr_heure", nativeQuery = true)
	List<Cours> findAllTriNbrHeure();
	
	@Query(value="select * from cours where cours_type=?1", nativeQuery = true)
	List<Cours> afficherCoursCoursType(String cType);
	
	@Query(value = "select * from cours where nom_matiere=?1", nativeQuery = true)
	List<Cours> afficherCoursNomMatiere(String nMatiere);
	
	// useless ?
	@Query(value = "select * from cours where id_cours IN (select id_cours from lecture where id_personne IN (select id_personne from personne where personne_type='etudiant' and id_personne IN (select id_personne from personne_classe where id_classe=?1)))", nativeQuery = true)
	List<Cours> afficherCoursClasseEtudiants(String idC);
	
	@Query(value = "select * from cours where id_cours IN (select id_cours from lecture where id_personne IN (select id_personne from personne where id_personne IN (select id_personne from personne_classe where id_classe=?1)))", nativeQuery = true)
	List<Cours> afficherCoursClasse(String idC);
	
	@Query(value = "select * from cours where id_cours IN (select id_cours from lecture where id_personne=?1)", nativeQuery = true)
	List<Cours> afficherCoursPersonne(String idP);
	
	@Query(value = "select * from cours where id_cours IN (select id_cours from lecture where id_personne IN (select id_personne from personne where personne_type=?1))", nativeQuery = true)
	List<Cours> afficherCoursPersonnesType(String type);
	
	@Query(value = "select * from cours where id_cours IN (select id_cours from lecture where id_personne IN (select id_personne from personne where personne_type='enseignant' and id_personne IN (select id_personne from profil where id_role=?1)))", nativeQuery = true)
	List<Cours> afficherCoursEnseignantsAdmin(String idR);
	
	@Query(value = "select * from cours where id_cours IN (select id_cours from lecture where id_personne IN (select id_personne from personne where personne_type='enseignant' and id_personne=?2 and id_personne IN (select id_personne from profil where id_role=?1)))", nativeQuery = true)
	List<Cours> afficherCoursEnseignantAdmin(String idR, String idE);
	
}
//	public String commandeSQL1 = "SELECT * from cours WHERE id_cours IN (SELECT id_cours from lecture WHERE id_personne =?1)";
//	@Query(value = commandeSQL1, nativeQuery = true)
//    List<Cours> listCours(String idCours);
//	
//	public String commandeSQL2 = "INSERT INTO fichier_cours from cours WHERE id_cours IN (SELECT id_cours from lecture where id_personne="
//	+ "	(select id_personne from personne where id_personne=?1 and personne_type='enseignant')) Value(?1,?2,?3)";
//	@Query(value = commandeSQL2, nativeQuery = true)
//	Cours insererCours(String idCours, String idPersonne, String fichierCours);
//
//	public String commandeSQL3 = "Update cours set fichier_cours=?3 from cours WHERE id_cours IN (SELECT id_cours from lecture where id_cours=?1 and id_personne="
//			+ "	(select id_personne from personne where id_personne=?2 and personne_type='enseignant'))";
//			@Query(value = commandeSQL3, nativeQuery = true)
//			Cours updaterCours(String idCours, String idPersonne, String fichierCours);
//}
