package com.geetest.entities;

import jakarta.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    String nominativeName;
    String genitiveName;
    String alias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
