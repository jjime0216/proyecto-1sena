package com.miproyectosena.proyectosena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.miproyectosena.proyectosena.models.Roles;
import com.miproyectosena.proyectosena.repositories.IRolesRepositorio;

@Component	
public class InicializarDatos implements CommandLineRunner {

    @Autowired
    private IRolesRepositorio iRolesRepositorio;

    @Override
    public void run(String... args) throws Exception {
        if (iRolesRepositorio.findByNombre("ROLE_COMPRADOR") == null) {
            iRolesRepositorio.save(new Roles("ROLE_COMPRADOR"));
        }
        if (iRolesRepositorio.findByNombre("ROLE_VENDEDOR") == null) {
            iRolesRepositorio.save(new Roles("ROLE_VENDEDOR"));
        }
    }
}
