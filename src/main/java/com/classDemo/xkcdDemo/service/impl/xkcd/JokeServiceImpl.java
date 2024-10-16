package com.classDemo.xkcdDemo.service.impl.xkcd;

import com.classDemo.xkcdDemo.domain.JokeResponse;
import com.classDemo.xkcdDemo.service.jokes.JokeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeServiceImpl implements JokeService {
    @Override
    public JokeResponse getRandomJoke() {
        RestTemplate restTemplate = new RestTemplate();
        JokeResponse result = restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke", JokeResponse.class);
        return result;
    }

    @Override
    public String[] getJokeTypes() {
        RestTemplate restTemplate = new RestTemplate();
        // The API call directly returns a String array
        return restTemplate.getForObject("https://official-joke-api.appspot.com/types", String[].class);
    }

    @Override
    public JokeResponse[] getRandomJokeType(String type) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://official-joke-api.appspot.com/jokes/" + type + "/random", JokeResponse[].class);
    }
}
