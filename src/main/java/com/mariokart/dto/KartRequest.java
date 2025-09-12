package com.mariokart.dto;

import lombok.Data;

@Data
public class KartRequest {
    private String slug;
    private String name;
    private String description;
    private String imageUrl;
    private Long kartTypeId;
}
