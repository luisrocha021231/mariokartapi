package com.mariokart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariokart.entities.KartType;

@Repository
public interface KartTypeRepository extends JpaRepository<KartType, Long> {

}
