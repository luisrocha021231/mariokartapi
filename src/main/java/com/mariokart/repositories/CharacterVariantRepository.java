package com.mariokart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariokart.entities.CharacterVariant;

@Repository
public interface CharacterVariantRepository extends JpaRepository<CharacterVariant, Long> {

}
