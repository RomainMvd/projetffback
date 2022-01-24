package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Presentiel;

@Repository
public interface PresentielRepository extends JpaRepository<Presentiel, Long>{

}
