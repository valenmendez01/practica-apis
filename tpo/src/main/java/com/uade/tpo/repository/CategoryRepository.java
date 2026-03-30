package com.uade.tpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uade.tpo.entity.Category;

@Repository

// Al heredar de JpaRepository, tu interfaz recibe automáticamente una implementación de los métodos estándar para manejar la entidad Category
// JpaRepository<Category, Integer> --> entidad + tipo de dato de ID
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Aquí no hace falta escribir nada más por ahora
}
