package com.geetest.entities;

import jakarta.persistence.*;

@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    String nominativeName;
    String genitiveName;
    String alias;
    //todo
    //Test tests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
