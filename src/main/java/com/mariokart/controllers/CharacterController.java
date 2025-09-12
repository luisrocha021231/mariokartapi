package com.mariokart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mariokart.entities.Character;
import com.mariokart.services.Characterservice;

@RestController
@RequestMapping("api/mariokart/characters")
public class CharacterController {
    
    @Autowired
    private Characterservice characterservice;

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterservice.getAllCharacters();
    }

    @PostMapping
    public void addCharacter(@RequestBody Character character) {
        characterservice.addCharacter(character);
    }
}
