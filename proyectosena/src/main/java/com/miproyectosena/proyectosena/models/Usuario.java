package com.miproyectosena.proyectosena.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="registro", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "numeroCelular")
    private String numeroCelular;
    @Column(name = "correo")
    private String correo;
    @Column(name = "password")
    private String password;

    
    public Usuario() {
    }

    
    public Usuario(String nombre, String apellido, String numeroCelular, String correo, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
        this.password = password;
    }


    public Usuario(Long id, String nombre, String apellido, String numeroCelular, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
        this.password = password;
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

}

