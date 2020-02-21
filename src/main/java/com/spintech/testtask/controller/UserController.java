package com.spintech.testtask.controller;

import com.spintech.testtask.dto.ActorDto;
import com.spintech.testtask.dto.RequestDto;
import com.spintech.testtask.dto.ShowDto;
import com.spintech.testtask.dto.UserDto;
import com.spintech.testtask.entity.Actor;
import com.spintech.testtask.entity.User;
import com.spintech.testtask.service.ActorService;
import com.spintech.testtask.service.UserService;
import com.spintech.testtask.util.UtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActorService actorService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@RequestBody RequestDto requestDto) {
        User user = userService.registerUser(requestDto.getEmail(), requestDto.getPassword());
        if (user != null) {
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(new UserDto(user.getId(), user.getEmail(), Collections.emptyList(), Collections.emptyList()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can not register user");
        }
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            List<ActorDto> favoriteActors = UtilMapper.toActorDto(user.getFavoriteActors());

            List<ShowDto> favoriteShow = UtilMapper.toShowDto(user.getFavoriteShow());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(new UserDto(user.getId(), user.getEmail(), favoriteActors, favoriteShow));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can not register user");
        }
    }

    @PostMapping
    public ResponseEntity addActorToFavorite(@RequestParam Long userId, @RequestParam Long actorId) {
        Optional<User> user = userService.findById(userId);
        Optional<Actor> actor = actorService.findById(actorId);
        if (user.isPresent() && actor.isPresent()) {

            User userFromDb = user.get();

            userFromDb.getFavoriteActors().add(actor.get());

            userFromDb = userService.updateUser(userFromDb);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new UserDto(userFromDb.getId(), userFromDb.getEmail(),
                            UtilMapper.toActorDto(userFromDb.getFavoriteActors()),
                            UtilMapper.toShowDto(userFromDb.getFavoriteShow())));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can not add actor");
        }
    }


}
