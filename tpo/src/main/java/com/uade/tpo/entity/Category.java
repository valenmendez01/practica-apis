package com.uade.tpo.entity;

import lombok.Builder;
import lombok.Data;

// brinda todos los getters y setters
@Data
@Builder
public class Category {
    private int id;
    private String description;
}


