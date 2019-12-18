package com.example.heroesservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hero {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    protected Hero() {
    }

    public Hero(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(getId(), hero.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
