package com.webapp.springBoot.dasBoot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webapp.springBoot.dasBoot.controller.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DasBootApplicationTests {

	@Test
	public void contextLoads() {
		HomeController hm = new HomeController();
		String result = hm.home();
		assertEquals(result,"welcome to demo project");
	}

}
