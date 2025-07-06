package com.example.repositories.implementations;

import com.example.models.Producto;
import com.example.repositories.ProductoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductoPanacheRepository implements ProductoRepository {

    private final EntityManagerFactory emf;


    @Override
    public List<Producto> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        }
    }

    @Override
    public Optional<Producto> findById(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return Optional.ofNullable(em.find(Producto.class, id));
        }
    }

    @Override
    public Optional<Producto> save(Producto producto) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            return Optional.of(producto);
        }
    }

    @Override
    public Optional<Producto> update(Producto producto) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Producto productoExistente = em.find(Producto.class, producto.getId());

            productoExistente.setNombre(producto.getNombre());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setSku(producto.getSku());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setExistencia(producto.getExistencia());
            productoExistente.setFechaModificacion(producto.getFechaModificacion());
            productoExistente.setFechaCreacion(producto.getFechaCreacion());

            em.persist(productoExistente);
            em.getTransaction().commit();
            return Optional.of(productoExistente);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Producto producto = em.find(Producto.class, id);

            if (producto != null) {
                em.remove(producto);
            }

            em.getTransaction().commit();
        }
    }
}
