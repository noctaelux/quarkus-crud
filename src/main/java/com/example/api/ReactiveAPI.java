package com.example.api;

import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestStreamElementType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@Path("/reactive")
public class ReactiveAPI {

    private final static Logger LOG = LoggerFactory.getLogger(ReactiveAPI.class);

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    @Path("/backpressure/{interval}/{message}")
    public Multi<String> stream(@PathParam("interval") long interval,@PathParam("message") String message) {

        LOG.debug("Serving a request every {} nanoseconds.",interval);

        return Multi
                .createFrom()
                .ticks()
                .every(Duration.ofNanos(interval))
                .onOverflow()
                .buffer(1000)
                .onItem()
                .transform(n -> String.format("Hello %s - sending message # %d.", message, n));

    }

}
