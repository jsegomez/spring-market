package com.jsegomez.market.persistence;

import com.jsegomez.market.persistence.crud.ProductoCrudRepository;
import com.jsegomez.market.persistence.entity.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoRepository;

    public List<Producto> findAll(){
        return (List<Producto>) productoRepository.findAll();
    }

    public Optional<Producto> findById(Integer id){
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteById(Integer idProducto){
        if (!productoRepository.existsById(idProducto)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto con id " + idProducto + " no existe.");
        }
        productoRepository.deleteById(idProducto);
    }
}

