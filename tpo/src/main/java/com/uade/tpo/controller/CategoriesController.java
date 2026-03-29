package com.uade.tpo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.service.CategoryService;
import com.uade.tpo.entity.Category;
import com.uade.tpo.entity.dto.CategoryRequest;
import com.uade.tpo.exceptions.CategoryDuplicateException;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// El controller es la capa de trafico. Es la que recibe las solicitudes http, las procesa y devuelve una respuesta. Es la que se encarga de mapear los endpoints y de llamar a los servicios para procesar la lógica de negocio.

@RestController // Le indica a Spring Boot que esto es la capa de trafico

// Le dice a Spring Boot que todas las peticiones que empiecen con /categories deben ser enviadas a esta clase. Si tu servidor corre en localhost:8080, la dirección de entrada para cualquier método dentro de este controlador será http://localhost:8080/categories.
@RequestMapping("categories") // Define la ruta base de tu API para ese recurso específico

public class CategoriesController {
    // Instanciamos el servicio para poder usarlo dentro del controller. El controller llama al servicio para que procese la lógica de negocio y devuelva un resultado, que luego el controller devuelve como respuesta http.
    private CategoryService categoryService;

    public CategoriesController() {
        categoryService = new CategoryService();
    }

    // Le dice a Spring Boot que este método debe ser llamado cuando se reciba una solicitud http GET en la ruta definida. En este caso, cuando se reciba una solicitud GET en http://localhost:8080/categories, se ejecutará el método getCategories().
    @GetMapping
    public ResponseEntity<ArrayList<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    // Lo mismo, pero con path variable mediante {}
    @GetMapping("/{categoryId}") // localhost:8080/categories/10
    public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId) {
        Optional<Category> result = categoryService.getCategoryById(categoryId);
        if (result.isPresent())
            return ResponseEntity.ok(result.get());

        return ResponseEntity.noContent().build();
    }
    
    @PostMapping
    public ResponseEntity<Object> createCategory(@RequestBody CategoryRequest categoryRequest)
            throws CategoryDuplicateException {
        Category result = categoryService.createCategory(categoryRequest.getId(), categoryRequest.getDescription());
        return ResponseEntity.created(URI.create("/categories/" + result.getId())).body(result);
    }
    
}

// ResponseEntity sirve para construir la respuesta http que se va a enviar al cliente.
// El método ok() devuelve una respuesta http con el código de estado 200 (OK) y el cuerpo de la respuesta es el resultado que se le pasa como parámetro. En este caso, el resultado es la lista de categorías que devuelve el servicio.
// El método noContent() devuelve una respuesta http con el código de estado 204 (No Content) y sin cuerpo de respuesta. Se usa cuando no se encuentra el recurso solicitado. El .build() se usa para construir la respuesta sin cuerpo de respuesta.
// El método created() devuelve una respuesta http con el código de estado 201 (Created) y el cuerpo de la respuesta es el resultado que se le pasa como parámetro. Se usa cuando se crea un nuevo recurso. En este caso, se le pasa el resultado de la creación de la categoría y se le indica la ubicación del nuevo recurso creado mediante URI.create("/categories/" + result.getId()).

// Optional es una clase que se usa para representar un valor que puede estar presente o no. Se usa para evitar el uso de null y para manejar de manera más segura los casos en los que un valor puede no estar presente. En este caso, el método getCategoryById devuelve un Optional<Category>, lo que significa que puede devolver una categoría o no devolver nada (si no se encuentra la categoría con el id solicitado). El controller luego verifica si el resultado está presente o no y devuelve la respuesta http correspondiente. 
// No se usa Optional para colecciones (Listas, Sets, Maps). Por ejemplo el método getCategories() siempre devuelve una lista, aunque esa lista esté vacía. En cambio, el método getCategoryById puede no encontrar la categoría solicitada (el objeto), por lo que se usa Optional para manejar ese caso de manera segura.

// @PathVariable se usa para indicar que un parámetro de un método debe ser obtenido de la ruta de la solicitud http.

// @RequestBody se usa para indicar que el cuerpo de la solicitud http debe ser mapeado a un objeto Java. En este caso, el cuerpo de la solicitud http debe ser un JSON que se mapee a un objeto CategoryRequest.