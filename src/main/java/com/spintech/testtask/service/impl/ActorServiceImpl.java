package com.spintech.testtask.service.impl;

import com.spintech.testtask.entity.Actor;
import com.spintech.testtask.repository.ActoreRepository;
import com.spintech.testtask.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActoreRepository actoreRepository;

    @Override
    public Actor save(Actor actor) {
        return actoreRepository.save(actor);
    }

    @Override
    public List<Actor> getAllActors() {
        List<Actor> result = new ArrayList<>();
        actoreRepository.findAll().forEach(result::add);

        return result;
    }

    @Override
    public Optional<Actor> findById(Long actorId) {
        return actoreRepository.findById(actorId);
    }
}
