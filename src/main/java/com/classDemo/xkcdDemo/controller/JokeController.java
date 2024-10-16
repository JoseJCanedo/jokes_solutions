package com.classDemo.xkcdDemo.controller;
import com.classDemo.xkcdDemo.domain.JokeResponse;
import com.classDemo.xkcdDemo.service.jokes.JokeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("jokes/random")
    public JokeResponse getRandomJoke(){
        return jokeService.getRandomJoke();
    }

    @GetMapping("jokes/types")
    public String[] getJokeTypes() {
        return jokeService.getJokeTypes();
    }

    @GetMapping("jokes/{type}")
    public JokeResponse[] getRandomJokeType(@PathVariable String type) {
        return jokeService.getRandomJokeType(type);
    }
}
