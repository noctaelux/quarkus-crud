package com.example.api;

import com.example.dto.ProductoDTO;
import com.example.services.ProductoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/producto")
public class ProductoApi {

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
    public ProductoDTO getProducto(@PathParam("id") Long id){
        return productoService.get(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductoDTO create(ProductoDTO producto) {
        return productoService.create(producto);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductoDTO update(ProductoDTO producto) {
        return productoService.update(producto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        productoService.delete(id);
    }

}
