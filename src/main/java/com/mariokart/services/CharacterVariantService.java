package com.mariokart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariokart.dto.CharacterVariantRequest;
import com.mariokart.entities.Character;
import com.mariokart.entities.CharacterVariant;
import com.mariokart.repositories.CharacterRepository;
import com.mariokart.repositories.CharacterVariantRepository;

@Service
public class CharacterVariantService {

    @Autowired
    private CharacterVariantRepository characterVariantRepository;

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterVariant addCharacterVariant(CharacterVariantRequest request) {

        // find the character by ID
        Character character = characterRepository.findById(request.getCharacterId())
                .orElseThrow(() -> new RuntimeException("Character not found"));

        // create the entity
        CharacterVariant variant = new CharacterVariant();
        variant.setSlug(request.getSlug());
        variant.setName(request.getName());
        variant.setDescription(request.getDescription());
        variant.setImageUrl(request.getImageUrl());
        variant.setCharacter(character);

        // save on DB
        return characterVariantRepository.save(variant);
    }

}
