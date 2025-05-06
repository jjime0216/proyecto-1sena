package com.miproyectosena.proyectosena.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.miproyectosena.proyectosena.dto.UsuarioDTO;
import com.miproyectosena.proyectosena.models.Usuario;
import com.miproyectosena.proyectosena.repositories.IUsuarioRepo;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioRepo iUsuarioRepo;

    @Override
    public Usuario guardar(UsuarioDTO registroDTO) {
       Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getNumeroCelular(), registroDTO.getCorreo(), passwordEncoder.encode(registroDTO.getPassword()));
       
       return iUsuarioRepo.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioRepo.findByCorreo(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña invalida");
        }
        return new User(usuario.getCorreo(), usuario.getPassword(), Collections.emptyList());
        
    }


}
