package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Producto {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String descripcion;
    private String sku;
    private Double precio;
    private Double existencia;
    private Date fechaCreacion;
    private Date fechaModificacion;

}
