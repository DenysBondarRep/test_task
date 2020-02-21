package com.spintech.testtask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Actor(String name) {
        this.name = name;
    }
}
