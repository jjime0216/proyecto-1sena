package com.miproyectosena.proyectosena.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioSesionController {

    @GetMapping("/login")
    public String iniciarSesion(){
        return "inicioSesion";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(){
        return "index";
    }
}
