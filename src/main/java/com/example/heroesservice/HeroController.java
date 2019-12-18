package com.example.heroesservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroRepository heroRepository;

    public HeroController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @GetMapping
    public List<Hero> getHeroes() {
        return heroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable Long id) {
        return heroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
        return new ResponseEntity<>(heroRepository.save(hero), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Hero updateHero(@PathVariable Long id, @RequestBody Hero newHero) {
        return heroRepository.findById(id)
                .map(hero -> {
                    hero.setName(newHero.getName());
                    return heroRepository.save(hero);
                })
                .orElseGet(() -> heroRepository.save(newHero));
    }
}