package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Distanciel;

@Repository
public interface DistancielRepository extends JpaRepository<Distanciel, Long>{

}
