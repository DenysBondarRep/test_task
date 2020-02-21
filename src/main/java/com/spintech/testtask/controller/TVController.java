package com.spintech.testtask.controller;

import com.spintech.testtask.service.UserService;
import com.spintech.testtask.service.tmdb.TmdbApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/tv")
public class TVController {

    @Autowired
    private UserService userService;

    @Autowired
    private TmdbApi tmdbApi;

    @RequestMapping(value = "/popular", method = POST)
    public ResponseEntity popular(@RequestBody String email,
                                  @RequestBody String password) {
        if (userService.findUser(email, password) == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        String popularMovies = tmdbApi.popularTVShows();

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(popularMovies);
    }
}
