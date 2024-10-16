package com.classDemo.xkcdDemo.service.impl.xkcd;

import com.classDemo.xkcdDemo.domain.XkcdResponse;
import com.classDemo.xkcdDemo.service.xkcd.XkcdService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class XkcdServiceImpl implements XkcdService {

    @Override
    public XkcdResponse getCurrentComic() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://xkcd.com/info.0.json", XkcdResponse.class);
    }

    @Override
    public XkcdResponse getPastComic(String comicNum) {
        RestTemplate restTemplate = new RestTemplate();
        if(comicNum == null){
            return null;
        }
        return restTemplate.getForObject("https://xkcd.com/"+ comicNum +"/info.0.json", XkcdResponse.class);
    }
}

