package com.miproyectosena.proyectosena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miproyectosena.proyectosena.models.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {
    public Usuario findByCorreo (String email);

}
