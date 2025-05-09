package com.miproyectosena.proyectosena.dto;

import java.util.List;

public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String numeroCelular;
    private String correo;
    private String password;
    private List<String> roles;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String correo) {
        this.correo = correo;
    }


    public UsuarioDTO(String nombre, String apellido, String numeroCelular, String correo, String password,
            List<String> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
        this.password = password;
        this.roles = roles;
    }

    public UsuarioDTO(Long id, String nombre, String apellido, String numeroCelular, String correo, String password,
            List<String> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    
}
