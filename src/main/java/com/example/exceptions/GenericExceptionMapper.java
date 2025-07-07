package com.example.exceptions;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.io.Serializable;
import java.util.Arrays;

@Provider
@RegisterForReflection
public class GenericExceptionMapper implements Serializable, ExceptionMapper<Exception> {

    public record ExceptionElementMessage(String message, String details) {}

    @Override
    public Response toResponse(Exception e){
        var error = new GenericExceptionMapper.ExceptionElementMessage(e.getMessage(), Arrays.toString(e.getStackTrace()));
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
}
