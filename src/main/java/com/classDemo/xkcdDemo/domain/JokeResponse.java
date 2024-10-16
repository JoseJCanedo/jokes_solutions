package com.classDemo.xkcdDemo.domain;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JokeResponse {
    private String type;
    private String setup;
    private String punchline;
    private int id;
}
