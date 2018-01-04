package com.example.views;

import io.dropwizard.views.View;

public class StartView extends View {

    private final String message;

    public StartView(String message) {
        super("Start.mustache");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
