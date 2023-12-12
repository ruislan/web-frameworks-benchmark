package com.ruislan.webframeworksbenchmark.javaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class JavaSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringbootApplication.class, args);
    }
}

@RestController
class HelloController {
	@GetMapping("/")
    public String sayHello() {
        return "{\"hello\":\"world\"}";
    }
}
