package com.miproyectosena.proyectosena.services;

import com.miproyectosena.proyectosena.dto.ProductoDTO;
import com.miproyectosena.proyectosena.models.Producto;

public interface IProductoServicio {

    public Producto guardarProducto (ProductoDTO productoDTO);
}
