package com.mariokart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariokart.entities.Tires;

@Repository
public interface TiresRepository extends JpaRepository<Tires, Long> {
    
}
