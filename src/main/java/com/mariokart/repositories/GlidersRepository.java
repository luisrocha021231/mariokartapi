package com.mariokart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariokart.entities.Gliders;

@Repository
public interface GlidersRepository extends JpaRepository<Gliders, Long> {

}
