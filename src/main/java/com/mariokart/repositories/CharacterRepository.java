package com.mariokart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mariokart.entities.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

}
