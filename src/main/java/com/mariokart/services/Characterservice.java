package com.mariokart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariokart.entities.Character;
import com.mariokart.repositories.CharacterRepository;

@Service
public class Characterservice {
    
    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public void addCharacter (Character character) {
        characterRepository.save(character);
    }
}
