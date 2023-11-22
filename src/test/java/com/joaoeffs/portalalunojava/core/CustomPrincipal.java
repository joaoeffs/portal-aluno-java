package com.joaoeffs.portalalunojava.core;

import java.util.UUID;

public class CustomPrincipal {
    private UUID id;

    public CustomPrincipal(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
