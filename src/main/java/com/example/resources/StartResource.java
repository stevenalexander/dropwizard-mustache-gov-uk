package com.example.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.views.govuk.GovUkView;
import com.example.views.StartView;
import io.dropwizard.views.mustache.MustacheViewRenderer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/start")
@Produces(MediaType.TEXT_HTML)
public class StartResource {
    private final MustacheViewRenderer mustacheViewRenderer;

    public StartResource(MustacheViewRenderer mustacheViewRenderer) {
        this.mustacheViewRenderer = mustacheViewRenderer;
    }

    @GET
    @Timed
    public GovUkView sayHello() {
        return new GovUkView(mustacheViewRenderer, new StartView("Hello"));
    }
}
