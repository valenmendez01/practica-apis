package com.uade.tpo.entity;

import lombok.Builder;
import lombok.Data;

// Entity es la representación de cómo se guardan los datos dentro de tu sistema o base de datos.

@Data // Genera automáticamente los métodos getters y setters para los campos de la clase
@Builder // Genera el constructor

public class Category {
    private int id;
    private String description;
}


