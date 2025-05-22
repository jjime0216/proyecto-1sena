package com.miproyectosena.proyectosena.dto;

import java.util.List;

public class ProductoDTO {
    private Long id;
    private String nombreProducto;
    private String fotografia;
    private String descripcion;
    private int costoProducto;
    private List<String> categoriaSeleccionada;
    private List<String> pagoSeleccionado;

    


    public ProductoDTO() {
    }

    

    public ProductoDTO(List<String> categoriaSeleccionada, List<String> pagoSeleccionado) {
        this.categoriaSeleccionada = categoriaSeleccionada;
        this.pagoSeleccionado = pagoSeleccionado;
    }



    public ProductoDTO(String nombreProducto, String fotografia, String descripcion, int costoProducto,
            List<String> categoriaSeleccionada, List<String> pagoSeleccionado) {
        this.nombreProducto = nombreProducto;
        this.fotografia = fotografia;
        this.descripcion = descripcion;
        this.costoProducto = costoProducto;
        this.categoriaSeleccionada = categoriaSeleccionada;
        this.pagoSeleccionado = pagoSeleccionado;
    }

    public ProductoDTO(Long id, String nombreProducto, String fotografia, String descripcion, int costoProducto,
            List<String> categoriaSeleccionada, List<String> pagoSeleccionado) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.fotografia = fotografia;
        this.descripcion = descripcion;
        this.costoProducto = costoProducto;
        this.categoriaSeleccionada = categoriaSeleccionada;
        this.pagoSeleccionado = pagoSeleccionado;
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCostoProducto() {
        return costoProducto;
    }
    public void setCostoProducto(int costoProducto) {
        this.costoProducto = costoProducto;
    }
    public List<String> getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }
    public void setCategoriaSeleccionada(List<String> categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }
    public List<String> getPagoSeleccionado() {
        return pagoSeleccionado;
    }
    public void setPagoSeleccionado(List<String> pagoSeleccionado) {
        this.pagoSeleccionado = pagoSeleccionado;
    }

    

}
