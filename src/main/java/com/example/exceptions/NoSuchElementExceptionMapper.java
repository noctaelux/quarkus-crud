package com.example.exceptions;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.io.Serializable;
import java.util.Arrays;
import java.util.NoSuchElementException;

@Provider
@RegisterForReflection
public class NoSuchElementExceptionMapper implements Serializable, ExceptionMapper<NoSuchElementException> {

    public record NoSuchElementMessage(String message, String details) {}

    @Override
    public Response toResponse(NoSuchElementException e) {
        var error = new NoSuchElementMessage(e.getMessage(), Arrays.toString(e.getStackTrace()));
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }

}
