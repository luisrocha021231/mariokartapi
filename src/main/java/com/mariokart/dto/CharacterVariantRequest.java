package com.mariokart.dto;

import lombok.Data;

@Data
public class CharacterVariantRequest {
    private String slug;
    private String name;
    private String description;
    private String imageUrl;
    private Long characterId;
}
