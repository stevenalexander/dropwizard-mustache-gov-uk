package com.example.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.views.StartView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/start")
@Produces(MediaType.TEXT_HTML)
public class StartResource {
    private final AtomicLong counter;

    public StartResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public StartView sayHello() {
        return new StartView("Hello times " + counter.incrementAndGet());
    }
}
