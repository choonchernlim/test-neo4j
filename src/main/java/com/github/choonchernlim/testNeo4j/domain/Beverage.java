package com.github.choonchernlim.testNeo4j.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public final class Beverage {

    @GraphId
    private Long id;

    private String name;

    public Beverage() {
    }

    public Beverage(final String name) {
        this.name = name;
    }
}
