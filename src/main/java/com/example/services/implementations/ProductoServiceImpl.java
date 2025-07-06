package com.example.services.implementations;

import com.example.dto.ProductoDTO;
import com.example.dto.ProductoMapper;
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
    public ProductoDTO get(Long id) {
        return productoRepository.findById(id)
                .map(ProductoMapper::toDTO)
                .orElseThrow(() -> new NoSuchElementException("No existe el producto con id " + id));
    }

    @Override
    public List<ProductoDTO> getAll() {
        return productoRepository.findAll().stream()
                .map(ProductoMapper::toDTO)
                .toList();
    }

    @Override
    public ProductoDTO create(ProductoDTO productoDTO) {

        Producto producto = ProductoMapper.toModel(productoDTO);

        producto.setFechaCreacion(Calendar.getInstance().getTime());
        producto.setFechaModificacion(null);

        return productoRepository.save(producto)
                .map(ProductoMapper::toDTO)
                .orElseThrow(() -> new NoSuchElementException("No se pudo crear el producto"));
    }

    @Override
    public ProductoDTO update(ProductoDTO productoDTO) {

        Producto producto = ProductoMapper.toModel(productoDTO);

        Optional<Producto> productoExistente = productoRepository.findById(producto.getId());

        if (productoExistente.isEmpty()) {
            throw new NoSuchElementException("No existe el producto con id " + producto.getId());
        }

        producto.setFechaModificacion(Calendar.getInstance().getTime());
        producto.setFechaCreacion(productoExistente.get().getFechaCreacion());

        return productoRepository.update(producto)
                .map(ProductoMapper::toDTO)
                .orElseThrow(() -> new NoSuchElementException("No se pudo actualizar el producto"));
    }

    @Override
    public void delete(Long id) {

        Optional<Producto> productoExistente = productoRepository.findById(id);

        if (productoExistente.isEmpty()) {
            throw new NoSuchElementException("No existe el producto con id " + id);
        }

        productoRepository.deleteById(productoExistente.get().getId());
    }
}
