package com.github.choonchernlim.testNeo4j.main;

import com.github.choonchernlim.testNeo4j.config.AppConfig;
import com.github.choonchernlim.testNeo4j.domain.Beverage;
import com.github.choonchernlim.testNeo4j.domain.Person;
import com.github.choonchernlim.testNeo4j.domain.Restaurant;
import com.github.choonchernlim.testNeo4j.repository.PersonRepository;
import com.google.common.collect.ImmutableSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public final class Main {
    private final PersonRepository personRepository;

    @Autowired
    public Main(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(Main.class).run();
    }

    public void run() {
        personRepository.deleteAll();

        final Restaurant noodlesAndCo = new Restaurant("Noodles and Co");
        final Restaurant johnHardies = new Restaurant("John Hardy's");
        final Restaurant whistleBinkies = new Restaurant("Whistle Binkies");
        final Restaurant subway = new Restaurant("Subway");
        final Restaurant newts = new Restaurant("Newts");

        final Beverage coldPress = new Beverage("Cold Press");
        final Beverage darkRoast = new Beverage("Dark Roast");
        final Beverage vanillaLatte = new Beverage("Vanilla Latte");
        final Beverage fufu = new Beverage("Fufu Drink");

        personRepository.save(
                new Person("Jason",
                           ImmutableSet.of(noodlesAndCo, johnHardies, whistleBinkies, newts),
                           ImmutableSet.of(coldPress, darkRoast),
                           null
                ));

        personRepository.save(
                new Person("Kurt",
                           ImmutableSet.of(noodlesAndCo, johnHardies, newts),
                           ImmutableSet.of(darkRoast),
                           ImmutableSet.of(coldPress)
                ));

        personRepository.save(
                new Person("Corey",
                           ImmutableSet.of(noodlesAndCo, newts, whistleBinkies),
                           ImmutableSet.of(vanillaLatte, darkRoast),
                           ImmutableSet.of(darkRoast)
                ));

        personRepository.save(
                new Person("Cory",
                           ImmutableSet.of(noodlesAndCo, newts, subway),
                           ImmutableSet.of(fufu),
                           ImmutableSet.of(coldPress, darkRoast, vanillaLatte)
                ));

        personRepository.save(
                new Person("Mike",
                           ImmutableSet.of(whistleBinkies, johnHardies, newts),
                           ImmutableSet.of(coldPress, darkRoast),
                           null));
    }
}
