package com.miproyectosena.proyectosena.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.miproyectosena.proyectosena.dto.ProductoDTO;
import com.miproyectosena.proyectosena.models.Usuario;
import com.miproyectosena.proyectosena.repositories.ICategoriaRepositorio;
import com.miproyectosena.proyectosena.repositories.IPagosRepositorio;
import com.miproyectosena.proyectosena.repositories.IUsuarioRepo;
import com.miproyectosena.proyectosena.services.ProductoServicioImpl;

import org.springframework.ui.Model;



@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoServicioImpl productoServicioImpl;

    @Autowired
    private IUsuarioRepo iUsuarioRepo;

    @Autowired
    private ICategoriaRepositorio iCategoriaRepositorio;

    @Autowired
    private IPagosRepositorio iPagosRepositorio;

    @GetMapping("/nuevo")
    public String mostrarFormularioProducto(Model model){
        model.addAttribute("productoDTO",new ProductoDTO());
        model.addAttribute("categoria", iCategoriaRepositorio.findAll());
        model.addAttribute("pagos", iPagosRepositorio.findAll());

        return "registroArticulo";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute ProductoDTO productoDTO,@RequestParam("archivo") MultipartFile imagen, Principal principal){
        Usuario usuario = iUsuarioRepo.findByCorreo(principal.getName());
        productoServicioImpl.guardarProducto(productoDTO, usuario, imagen);
        return "/";
    }
}
