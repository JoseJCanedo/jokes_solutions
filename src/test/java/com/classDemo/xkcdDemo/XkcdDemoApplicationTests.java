package com.classDemo.xkcdDemo;

import com.classDemo.xkcdDemo.domain.XkcdResponse;
import com.classDemo.xkcdDemo.service.xkcd.XkcdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class XkcdDemoApplicationTests {

	@Autowired
	private XkcdService xkcdService;

	// Without having setup a mocked API call we can only assert if Null or not Null since the data is dynamic
	//
	@Test
	void testCurrent() {
		XkcdResponse resp =  xkcdService.getCurrentComic();
		assertNotNull(resp);
	}

	@Test
	void testPast() {
		XkcdResponse resp =  xkcdService.getPastComic("123");
		assertNotNull(resp);
	}

	@Test
	void testPastNull() {
		XkcdResponse resp =  xkcdService.getPastComic(null);
		assertNull(resp);
	}

}
