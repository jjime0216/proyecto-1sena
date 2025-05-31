package com.miproyectosena.proyectosena.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.miproyectosena.proyectosena.models.Producto;
import com.miproyectosena.proyectosena.models.Usuario;
import com.miproyectosena.proyectosena.repositories.IUsuarioRepo;
import com.miproyectosena.proyectosena.services.ProductoServicioImpl;

import org.springframework.ui.Model;

@Controller
public class InicioSesionController {

    @Autowired
    private ProductoServicioImpl productoServicioImpl;
    @Autowired
    private IUsuarioRepo iUsuarioRepo;

    @GetMapping("/login")
    public String iniciarSesion(){
        return "inicioSesion";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model model, Principal principal){
        List<Producto> productos;

        if (principal==null) {
            productos = productoServicioImpl.obtenerTodosLosProductos();
        } else {
            Usuario usuario = iUsuarioRepo.findByCorreo(principal.getName());
            productos = productoServicioImpl.obtenerProductosPorRol(usuario);
            }
            model.addAttribute("productos", productos);
            return "index";
    }
}
