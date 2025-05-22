package com.miproyectosena.proyectosena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.miproyectosena.proyectosena.models.Categoria;
import com.miproyectosena.proyectosena.repositories.ICategoriaRepositorio;

@Component
public class CategoriaDatos implements CommandLineRunner {

    @Autowired
    private ICategoriaRepositorio iCategoriaRepositorio;

    @Override
    public void run(String... args) throws Exception {
         if (iCategoriaRepositorio.count() == 0) {
            // Inserta solo si no hay categorías
            iCategoriaRepositorio.save(new Categoria("Hogar"));
            iCategoriaRepositorio.save(new Categoria("Ropa y accesorios"));
            iCategoriaRepositorio.save(new Categoria("Juguetes"));
            iCategoriaRepositorio.save(new Categoria("Deporte"));
            iCategoriaRepositorio.save(new Categoria("Tecnologia"));
        }
    }
}
