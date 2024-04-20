package com.springbootapirest.springbootapirest.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapirest.springbootapirest.Entities.Productos;
import com.springbootapirest.springbootapirest.Services.ProductosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    ProductosService productosService;

    @GetMapping("/getAllProducts")
    public ArrayList<Productos> obtenerProductos() {
        return productosService.obtenerTodosLosProductos();
    }

    @GetMapping("/getProductById/{id}")
    public Optional<Productos> obtenerProductosPorId(@PathVariable Long id) {
        return productosService.obtenerProductoPorId(id);
    }

    @PostMapping("/postProduct")
    public Productos guardarProducto(@RequestBody Productos producto) {
        return productosService.agregarProducto(producto);
    }
    
    @DeleteMapping("/deleteProductById/{id}")
    public String eliminarProducto(@PathVariable Long id){
        Boolean x= productosService.borrarProducto(id);
        if (x) {
            return "El producto con el id "+ id+ " ha sido eliminado correctamente";
        }else{
            return "El producto con el id "+ id+ " No se pudo eliminar, no existe";
        }
    }

    @PutMapping("/actualizarProducto/{id}")
    public Productos actualizarProducto(@PathVariable("id") Long id, @RequestBody Productos producto) {       
        return productosService.actualizarProducto(id, producto);
    }
}