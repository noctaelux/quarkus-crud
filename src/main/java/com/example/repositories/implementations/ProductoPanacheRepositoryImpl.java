package com.example.repositories.implementations;

import com.example.models.Producto;
import com.example.repositories.ProductoPanacheRepository;
import com.example.repositories.ProductoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class ProductoPanacheRepositoryImpl implements ProductoRepository {

    ProductoPanacheRepository productoPanacheRepository;

    @Inject
    public ProductoPanacheRepositoryImpl(ProductoPanacheRepository productoPanacheRepository) {
        this.productoPanacheRepository = productoPanacheRepository;
    }

    @Override
    public List<Producto> findAll() {
        return productoPanacheRepository.findAll().stream().toList();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoPanacheRepository.findByIdOptional(id);
    }

    @Override
    public Optional<Producto> save(Producto producto) {
        productoPanacheRepository.persist(producto);
        return Optional.ofNullable(producto);
    }

    @Override
    public Optional<Producto> update(Producto producto) {

        Producto productoExistente = productoPanacheRepository.findByIdOptional(producto.getId()).orElse(null);

        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setSku(producto.getSku());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setExistencia(producto.getExistencia());
        productoExistente.setFechaCreacion(producto.getFechaCreacion());
        productoExistente.setFechaModificacion(producto.getFechaModificacion());

        productoPanacheRepository.persist(productoExistente);

        return Optional.of(productoExistente);
    }

    @Override
    public void deleteById(Long id) {
        productoPanacheRepository.deleteById(id);
    }
}
