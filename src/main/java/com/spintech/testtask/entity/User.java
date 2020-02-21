package com.spintech.testtask.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "user_favorite_actors", joinColumns = {
            @JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private List<Actor> favoriteActors;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "user_favorite_show", joinColumns = {
            @JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "show_id")})
    private List<Show> favoriteShow;

}