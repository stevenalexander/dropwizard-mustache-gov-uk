package com.example;

import com.example.resources.StartResource;
import com.google.common.collect.ImmutableList;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.views.ViewRenderer;
import io.dropwizard.views.mustache.MustacheViewRenderer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ExampleApplication extends Application<ExampleConfiguration> {

    private final MustacheViewRenderer mustacheViewRenderer = new MustacheViewRenderer();

    public static void main(final String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-mustache-gob-uk";
    }

    @Override
    public void initialize(final Bootstrap<ExampleConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/public"));
        bootstrap.addBundle(new ViewBundle<>(ImmutableList.of(mustacheViewRenderer)));
    }

    @Override
    public void run(final ExampleConfiguration configuration,
                    final Environment environment) {
        final StartResource startResource = new StartResource(mustacheViewRenderer);

        environment.jersey().register(startResource);
    }

}
