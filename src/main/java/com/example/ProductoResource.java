package com.example;

import com.example.models.Producto;
import com.example.services.ProductoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/producto")
public class ProductoResource {

    @Inject
    ProductoService productoService;

    @GET
    @Path("/lista")
    public Response traeProductos(){
        return Response.ok(productoService.getAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Producto getProducto(@PathParam("id") Long id){
        return productoService.get(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Producto create(Producto producto) {
        return productoService.create(producto);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Producto update(Producto producto) {
        return productoService.update(producto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        productoService.delete(id);
    }

}
