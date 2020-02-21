package com.spintech.testtask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "show_actors", joinColumns = {
            @JoinColumn(name = "show_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
    private List<Actor> actors;
}
