package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/{name}")
    public String helloName(@PathParam("name") String name) {
        return "Hello from path param " + name;
    }

    @GET
    @Path("/query")
    public String helloQuery(@QueryParam("name") String name) {
        return Optional.ofNullable(name)
                .map(n -> "Hello " + n)
                .orElse("Agregue el parámetro name en la petición.");
    }
}
