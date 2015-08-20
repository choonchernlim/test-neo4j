package com.github.choonchernlim.testNeo4j.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public final class Restaurant {

    @GraphId
    private Long id;

    private String name;

    public Restaurant() {
    }

    public Restaurant(final String name) {
        this.name = name;
    }
}
