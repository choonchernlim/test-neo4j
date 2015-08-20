package com.github.choonchernlim.testNeo4j.domain;

import static org.neo4j.graphdb.Direction.OUTGOING;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Set;

@NodeEntity
public final class Person {

    @Fetch
    @RelatedTo(type = "loves", direction = OUTGOING, enforceTargetType = true)
    public Set<Restaurant> lovesRestaurants;
    @Fetch
    @RelatedTo(type = "loves", direction = OUTGOING, enforceTargetType = true)
    public Set<Beverage> lovesBeverages;
    @Fetch
    @RelatedTo(type = "hates", direction = OUTGOING)
    public Set<Beverage> hatesBeverages;
    @GraphId
    private Long id;
    private String name;

    public Person() {
    }

    public Person(final String name,
                  final Set<Restaurant> lovesRestaurants,
                  final Set<Beverage> lovesBeverages,
                  final Set<Beverage> hatesBeverages) {
        this.name = name;
        this.lovesRestaurants = lovesRestaurants;
        this.lovesBeverages = lovesBeverages;
        this.hatesBeverages = hatesBeverages;
    }
}
