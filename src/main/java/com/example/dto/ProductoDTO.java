package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductoDTO implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
    private String sku;
    private Double precio;
    private Double existencia;
    private Date fechaCreacion;
    private Date fechaModificacion;

}
