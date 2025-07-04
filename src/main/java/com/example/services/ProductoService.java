package com.example.services;

import com.example.models.Producto;

import java.util.List;

public interface ProductoService {

    Producto get(Long id);
    List<Producto> getAll();
    Producto create(Producto producto);
    Producto update(Producto producto);
    void delete(Long id);

}
