package com.spintech.testtask.controller;

import com.spintech.testtask.dto.ActorDto;
import com.spintech.testtask.entity.Actor;
import com.spintech.testtask.service.ActorService;
import com.spintech.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createActor(@RequestBody ActorDto actor) {

//        if (userService.findUser(email, password) == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }

        Actor actorSaved = actorService.save(new Actor(actor.getName()));

        actor.setId(actorSaved.getId());

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(actor);
    }

    @GetMapping
    public ResponseEntity getAllActors() {

        List<Actor> allActors = actorService.getAllActors();
        List<ActorDto> actorDtos = allActors.stream()
                .map(actor -> new ActorDto(actor.getId(), actor.getName()))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(actorDtos);
    }


}
