package com.miproyectosena.proyectosena.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_Producto")
    private String nombreProducto;
    @Column(name = "fotografia")
    private String fotografia;
    @Column(name = "descripcion")
    private String descripcionProducto;
    @Column(name = "costo_Producto")
    private int costoProducto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
        name = "producto_pagos",
        joinColumns = @JoinColumn(name = "producto_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "pagos_id", referencedColumnName = "id")
    )
    private Set<Pagos> pagos = new HashSet<>();


    

    public Producto() {
    }

    

    public Producto(Long id, String nombreProducto, String fotografia, String descripcionProducto, int costoProducto,
            Usuario usuario, Categoria categoria, Set<Pagos> pagos) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.fotografia = fotografia;
        this.descripcionProducto = descripcionProducto;
        this.costoProducto = costoProducto;
        this.usuario = usuario;
        this.categoria = categoria;
        this.pagos = pagos;
    }

    
    public Producto(String nombreProducto, String fotografia, String descripcionProducto, int costoProducto,
            Usuario usuario, Categoria categoria, Set<Pagos> pagos) {
        this.nombreProducto = nombreProducto;
        this.fotografia = fotografia;
        this.descripcionProducto = descripcionProducto;
        this.costoProducto = costoProducto;
        this.usuario = usuario;
        this.categoria = categoria;
        this.pagos = pagos;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(int costoProducto) {
        this.costoProducto = costoProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Pagos> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pagos> pagos) {
        this.pagos = pagos;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
