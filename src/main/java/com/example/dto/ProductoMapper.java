package com.example.dto;

import com.example.models.Producto;

public class ProductoMapper {

    public static ProductoDTO toDTO(Producto producto) {

        return ProductoDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .sku(producto.getSku())
                .precio(producto.getPrecio())
                .existencia(producto.getExistencia())
                .fechaCreacion(producto.getFechaCreacion())
                .fechaModificacion(producto.getFechaModificacion())
                .build();
    }

    public static Producto toModel(ProductoDTO dto) {

        return Producto.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .sku(dto.getSku())
                .precio(dto.getPrecio())
                .existencia(dto.getExistencia())
                .fechaCreacion(dto.getFechaCreacion())
                .fechaModificacion(dto.getFechaModificacion())
                .build();
    }

}
