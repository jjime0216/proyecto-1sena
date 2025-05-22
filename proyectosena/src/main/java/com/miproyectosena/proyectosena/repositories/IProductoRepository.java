package com.miproyectosena.proyectosena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miproyectosena.proyectosena.models.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
}
