package com.classDemo.xkcdDemo.controller;

import com.classDemo.xkcdDemo.domain.XkcdResponse;
import com.classDemo.xkcdDemo.service.xkcd.XkcdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XkcdController {

    @Autowired
    private XkcdService xkcdService;

    @GetMapping("/current")
    public XkcdResponse getComic() {
        return xkcdService.getCurrentComic();
    }

    // pathVariable is part of the url -> https://xkcd.com/614/info.0.json path variable is 614 Mandatory
    // request parameter (query parameter) -> https://xkcd.com/info.0.json?comic=614 -> varName comic value 614 Optional

    @GetMapping("/past/{comicNum}")
    public XkcdResponse getPastComicPathVar(@PathVariable String comicNum){
        return xkcdService.getPastComic(comicNum);
    }

    @GetMapping("/pastOptional")
    public XkcdResponse getPastComicRequestParam(@RequestParam("comicNum") String comicNum){
        return xkcdService.getPastComic(comicNum);
    }
}
