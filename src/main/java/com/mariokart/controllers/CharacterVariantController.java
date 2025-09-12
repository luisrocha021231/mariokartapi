package com.mariokart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mariokart.dto.CharacterVariantRequest;
import com.mariokart.entities.CharacterVariant;
import com.mariokart.services.CharacterVariantService;

@RestController
@RequestMapping("/api/mariokart/character-variants")
public class CharacterVariantController {

    @Autowired
    private CharacterVariantService characterVariantService;

    @PostMapping
    public CharacterVariant create(@RequestBody CharacterVariantRequest request) {
        return characterVariantService.addCharacterVariant(request);
    }

}
