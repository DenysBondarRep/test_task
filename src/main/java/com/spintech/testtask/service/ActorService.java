package com.spintech.testtask.service;

import com.spintech.testtask.entity.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    Actor save(Actor actor);

    List<Actor> getAllActors();

    Optional<Actor> findById(Long actorId);
}
