package com.miproyectosena.proyectosena.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.miproyectosena.proyectosena.dto.ProductoDTO;
import com.miproyectosena.proyectosena.models.Categoria;
import com.miproyectosena.proyectosena.models.Pagos;
import com.miproyectosena.proyectosena.models.Producto;
import com.miproyectosena.proyectosena.models.Usuario;
import com.miproyectosena.proyectosena.repositories.ICategoriaRepositorio;
import com.miproyectosena.proyectosena.repositories.IPagosRepositorio;
import com.miproyectosena.proyectosena.repositories.IProductoRepository;

@Service
public class ProductoServicioImpl {

    @Autowired
    private IProductoRepository iProductoRepository;

    @Autowired
    private IPagosRepositorio iPagosRepositorio;

    @Autowired
    private ICategoriaRepositorio iCategoriaRepositorio;

    // Para vendedores
    public List<Producto> getProductosDelUsuario(Usuario usuario) {
        return iProductoRepository.findByUsuario(usuario);
    }

    public Producto guardarProducto(ProductoDTO dto, Usuario usuario, MultipartFile archivo){
        Producto producto = new Producto();
        producto.setNombreProducto(dto.getNombreProducto());
        producto.setDescripcionProducto(dto.getDescripcionProducto());
        producto.setCostoProducto(dto.getCostoProducto());
        producto.setUsuario(usuario);

        // Guarfar imagen en el disco
        if (!archivo.isEmpty()) {
            try{
                String nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename();
                Path ruta = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
                Files.createDirectories(ruta.getParent());
                Files.copy(archivo.getInputStream(),ruta, StandardCopyOption.REPLACE_EXISTING);
                producto.setFotografia(nombreArchivo);
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }

        Categoria categoria = iCategoriaRepositorio.findById(dto.getCategoria_id()).orElse(null);
        producto.setCategoria(categoria);

        Set<Pagos> pagos = new HashSet<>();
        for (String nombrePagos: dto.getPagoSeleccionado()){
            Pagos pago = iPagosRepositorio.findByNombrePagos(nombrePagos);
            if (pago != null) {
                pagos.add(pago);
            }
        }
        producto.setPagos(pagos);

        return iProductoRepository.save(producto);
        
    }

    // Para compradores
    public List<Producto> obtenerTodosLosProductos() {
        return iProductoRepository.findAll();
    }
}
