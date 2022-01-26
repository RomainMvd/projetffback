package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Classe;
import com.inti.entities.Personne;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
	
	@Query(value = "select * from classe order by nom_classe", nativeQuery = true)
	List<Classe> findAllTriNomClasse();
	
	@Query(value="select * from classe where id_classe IN (select id_classe from personne_classe where id_personne=?1)", nativeQuery = true)
	List<Classe> afficherClassesPersonne(String idP);
	
	@Query(value = "select * from classe where id_classe IN (select id_classe from personne_classe where id_personne IN (select id_personne from personne where personne_type=?1))", nativeQuery = true)
	List<Classe> afficherClassesPersonneType(String type);
	
	@Query(value = "select * from classe where id_classe IN (select id_classe from personne_classe where id_personne IN (select id_personne from personne where id_personne IN (select id_personne from lecture where id_cours=?1)))", nativeQuery = true)
	List<Classe> afficherClassesCours(String idC);
	
	@Query(value = "select * from classe where id_classe IN (select id_classe from personne_classe where id_personne IN (select id_personne from personne where personne_type='enseignant' and id_personne=?1))", nativeQuery = true)
	List<Classe> afficherClassesEnseignantAdmin(String idE);
	
	Classe findByNomClasse(String nomClasse);
	
}
