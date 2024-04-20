package com.springbootapirest.springbootapirest.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootapirest.springbootapirest.Entities.Productos;
import com.springbootapirest.springbootapirest.Repositories.ProductoRepository;

@Service
public class ProductosService {

    @Autowired
    ProductoRepository productoRepository;

    //Función GET
    public ArrayList<Productos> obtenerTodosLosProductos(){
        return (ArrayList<Productos>) productoRepository.findAll();
    }

    //Función GET
    public Optional<Productos> obtenerProductoPorId(Long id){
        return productoRepository.findById(id);
    }

    //Función POST
    public Productos agregarProducto(Productos producto){
        return productoRepository.save(producto);
    }

    //Función DELETE
    public Boolean borrarProducto(Long id){
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Función PUT
    public Productos actualizarProducto(Long id, Productos producto){
        Productos producto_encontrado= productoRepository.findById(id).get();
        producto_encontrado.setNombre(producto.getNombre());
        producto_encontrado.setPrecio(producto.getPrecio());
        return productoRepository.save(producto_encontrado);
    }
}
