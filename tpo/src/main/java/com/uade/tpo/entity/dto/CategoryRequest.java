package com.uade.tpo.entity.dto;

import lombok.Data;

@Data

// Es un DTO (Data Transfer Object). Se usa específicamente para recibir datos desde afuera (por ejemplo, cuando alguien quiere crear una categoría nueva).

// El DTO es lo que le pides al mundo exterior que te envíe. Es como el formulario que llena un cliente. Imagina que tu Category tuviera un campo fechaDeCreacion o usuarioQueLoCreo. El cliente no debería mandarte eso; eso lo genera tu sistema. El DTO solo tendría id y description porque es lo único que el usuario debe completar.

public class CategoryRequest {
    private int id;
    private String description;
}