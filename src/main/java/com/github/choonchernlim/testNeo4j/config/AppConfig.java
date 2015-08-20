package com.github.choonchernlim.testNeo4j.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

@Configuration
@ComponentScan("com.github.choonchernlim.testNeo4j")
@EnableNeo4jRepositories(basePackages = "com.github.choonchernlim.testNeo4j.repository")
public class AppConfig extends Neo4jConfiguration {

    public AppConfig() {
        setBasePackage("com.github.choonchernlim.testNeo4j.domain");
    }

    @Bean
    public SpringCypherRestGraphDatabase graphDatabaseService() {
        return new SpringCypherRestGraphDatabase("http://localhost:7474/db/data");
    }
}
