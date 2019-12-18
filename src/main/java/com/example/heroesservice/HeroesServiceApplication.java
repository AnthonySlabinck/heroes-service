package com.example.heroesservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class HeroesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroesServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(HeroRepository heroRepository) {
        return args -> Stream.of("Dr Nice", "Narco", "Bombasto", "Celeritas", "Magneta",
                "RubberMan", "Dynama", "Dr IQ", "Magma", "Tornado")
                .map(name -> new Hero(name))
                .forEach(heroRepository::save);
    }

}
