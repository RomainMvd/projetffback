package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long>{

}
