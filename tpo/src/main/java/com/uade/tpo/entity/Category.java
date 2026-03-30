package com.uade.tpo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

// Entity es la representación de cómo se guardan los datos dentro de tu sistema o base de datos.

@Data // Genera automáticamente los métodos getters y setters para los campos de la clase
@Builder // Genera el constructor
@Entity // Marca que Category es entidad, o sea algo que quiero persistir en la BDD

public class Category {
    @Id // define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;
}


