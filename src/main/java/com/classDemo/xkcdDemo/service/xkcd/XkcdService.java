package com.classDemo.xkcdDemo.service.xkcd;

import com.classDemo.xkcdDemo.domain.XkcdResponse;

public interface XkcdService {
    XkcdResponse getCurrentComic();

    XkcdResponse getPastComic(String comicNum);
}
