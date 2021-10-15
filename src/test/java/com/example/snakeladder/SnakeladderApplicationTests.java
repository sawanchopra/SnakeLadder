package com.example.snakeladder;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;
import org.springframework.boot.Bootstrapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

@SpringBootTest
class SnakeladderApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testMainTestData() throws Exception {
		System.out.println("main");
		String[] args = null;
		final InputStream original = System.in;
		URL resource = SnakeladderApplicationTests.class.getResource("/testcase");
		final FileInputStream fips = new FileInputStream(Paths.get(resource.toURI()).toFile());
		System.setIn(fips);
		SnakeladderApplication.main(args);
	}
}
