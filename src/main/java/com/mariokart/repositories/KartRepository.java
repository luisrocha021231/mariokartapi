package com.mariokart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariokart.entities.Kart;

@Repository
public interface KartRepository extends JpaRepository<Kart, Long> {

}
