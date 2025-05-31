package com.miproyectosena.proyectosena.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductoDTO {
    private Long id;
    private String nombreProducto;
    private MultipartFile archivoImagen;
    private String descripcionProducto;
    private Integer costoProducto;
    private Long categoria_id;
    private List<String> pagoSeleccionado;


    public ProductoDTO() {
    }
 


    public ProductoDTO(Long categoria_id, List<String> pagoSeleccionado) {
        this.categoria_id = categoria_id;
        this.pagoSeleccionado = pagoSeleccionado;
    }


    public ProductoDTO(String nombreProducto, MultipartFile archivoImagen, String descripcionProducto,
            Integer costoProducto, Long categoria_id, List<String> pagoSeleccionado) {
        this.nombreProducto = nombreProducto;
        this.archivoImagen = archivoImagen;
        this.descripcionProducto = descripcionProducto;
        this.costoProducto = costoProducto;
        this.categoria_id = categoria_id;
        this.pagoSeleccionado = pagoSeleccionado;
    }






    public ProductoDTO(Long id, String nombreProducto, MultipartFile archivoImagen, String descripcionProducto,
            Integer costoProducto, Long categoria_id, List<String> pagoSeleccionado) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.archivoImagen = archivoImagen;
        this.descripcionProducto = descripcionProducto;
        this.costoProducto = costoProducto;
        this.categoria_id = categoria_id;
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
    public Integer getCostoProducto() {
        return costoProducto;
    }
    public void setCostoProducto(Integer costoProducto) {
        this.costoProducto = costoProducto;
    }
    public List<String> getPagoSeleccionado() {
        return pagoSeleccionado;
    }
    public void setPagoSeleccionado(List<String> pagoSeleccionado) {
        this.pagoSeleccionado = pagoSeleccionado;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }



    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public MultipartFile getArchivoImagen() {
        return archivoImagen;
    }

    public void setArchivoImagen(MultipartFile archivoImagen) {
        this.archivoImagen = archivoImagen;
    }

    

}
