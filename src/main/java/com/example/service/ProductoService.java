package com.example.service;

import com.example.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto get(Long id);
    List<Producto> getAll();
    Producto create(Producto producto);
    Producto update(Producto producto);
    void delete(Producto producto);

}
