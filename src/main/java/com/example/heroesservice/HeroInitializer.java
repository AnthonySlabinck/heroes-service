package com.example.heroesservice;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
class HeroInitializer {

    private final HeroRepository repository;

    HeroInitializer(HeroRepository repository) {
        this.repository = repository;
    }

    @EventListener
    void on(ApplicationReadyEvent event) {
        if (repository.count() > 0) {
            return;
        }

        Stream.of("Dr Nice", "Narco", "Bombasto", "Celeritas", "Magneta",
                "RubberMan", "Dynama", "Dr IQ", "Magma", "Tornado")
                .map(name -> new Hero(name))
                .forEach(repository::save);
    }
}
