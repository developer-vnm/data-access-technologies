package io.github.example.application;

import io.github.example.application.services.ItemService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataJpaHibernateApplication implements CommandLineRunner {

	private final List<ItemService> itemServices;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaHibernateApplication.class, args);
	}

	@Override
	public void run(final String... args) {
		itemServices.forEach(itemService -> itemService.increaseAmount(1L, 10L));
	}
}