package io.github.example.application;

import io.github.example.application.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MybatisSpringBootApplication implements CommandLineRunner {

    private final ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBootApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        itemService.increaseAmount(1L, 10L);
    }
}
