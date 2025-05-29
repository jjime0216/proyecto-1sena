package com.miproyectosena.proyectosena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.miproyectosena.proyectosena.models.Pagos;
import com.miproyectosena.proyectosena.repositories.IPagosRepositorio;

@Component
public class PagosDatos implements CommandLineRunner {

    @Autowired
    private IPagosRepositorio iPagosRepositorio;

    @Override
    public void run(String... args) throws Exception {
        if (iPagosRepositorio.findByNombrePagos("TC") == null) {
            iPagosRepositorio.save(new Pagos("TC"));
        }
        if (iPagosRepositorio.findByNombrePagos("TD") == null) {
            iPagosRepositorio.save(new Pagos("TD"));
        }
        if (iPagosRepositorio.findByNombrePagos("CE") == null) {
            iPagosRepositorio.save(new Pagos("CE"));
        }
    }
}
