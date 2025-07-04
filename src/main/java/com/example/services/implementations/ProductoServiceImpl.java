package com.example.services.implementations;

import com.example.models.Producto;
import com.example.repositories.ProductoRepository;
import com.example.services.ProductoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.*;

@ApplicationScoped
@Transactional
public class ProductoServiceImpl implements ProductoService {

    @Inject
    ProductoRepository productoRepository;

    @Override
    public Producto get(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> getAll() {
        return productoRepository.listAll();
    }

    @Override
    public Producto create(Producto producto) {

        producto.setFechaCreacion(Calendar.getInstance().getTime());
        producto.setFechaModificacion(null);

        productoRepository.persist(producto);
        return producto;
    }

    @Override
    public Producto update(Producto producto) {

        if (productoRepository.findById(producto.getId()) == null) {
            throw new NoSuchElementException("No existe el producto con id " + producto.getId());
        }

        Producto productoExistente = productoRepository.findById(producto.getId());

        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setSku(producto.getSku());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setExistencia(producto.getExistencia());
        productoExistente.setFechaModificacion(Calendar.getInstance().getTime());

        productoRepository.persist(productoExistente);
        return productoExistente;
    }

    @Override
    public void delete(Long id) {

        Optional<Producto> productoExistente = Optional.ofNullable(productoRepository.findById(id));

        if (productoExistente.isEmpty()) {
            throw new NoSuchElementException("No existe el producto con id " + id);
        }

        productoRepository.deleteById(productoExistente.get().getId());
    }
}
