package com.example.repositories;

import com.example.models.Producto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductoPanacheRepository implements PanacheRepositoryBase<Producto, Long> {
}
