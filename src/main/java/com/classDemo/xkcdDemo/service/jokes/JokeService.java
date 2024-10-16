package com.classDemo.xkcdDemo.service.jokes;

import com.classDemo.xkcdDemo.domain.JokeResponse;

public interface JokeService {

    JokeResponse getRandomJoke();
    String[] getJokeTypes();
    JokeResponse[] getRandomJokeType(String type);

}
