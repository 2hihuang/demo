package com.example.demo;

import com.example.demo.bean.Demo;
import com.example.demo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private DemoService demoService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetById() {
		Demo demo = demoService.getById(Long.valueOf(1));
		assertThat(demo.getName()).isEqualTo("Bratislava");

	}
}
