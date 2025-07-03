package com.example;

import com.example.model.Producto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Calendar;
import java.util.List;

@Path("/producto")
public class ProductoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lista")
    public List<Producto> traeProductos(){


        Producto producto1 = new Producto();
        producto1.setId(123L);
        producto1.setNombre("Producto1");
        producto1.setDescripcion("Un producto de prueba");
        producto1.setExistencia(25d);
        producto1.setSku("3940F20340D");
        producto1.setPrecio(55.50);
        producto1.setFechaCreacion(Calendar.getInstance().getTime());

        List<Producto> productos = List.of(producto1);

        return productos;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Producto getProducto(){

        Producto producto1 = new Producto();
        producto1.setId(123L);
        producto1.setNombre("Producto1");
        producto1.setDescripcion("Un producto de prueba");
        producto1.setExistencia(25d);
        producto1.setSku("3940F20340D");
        producto1.setPrecio(55.50);
        producto1.setFechaCreacion(Calendar.getInstance().getTime());

        return producto1;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Producto create(Producto producto) {
        return producto;
    }

}
