package com.app;

import com.app.practice01.repository.IUserRepository;
import com.app.practice01.repository.UserRepositoryImpl;
import com.app.practice01.service.IUserService;
import com.app.practice01.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MapstructPracticesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapstructPracticesApplication.class, args);
	}

	@Bean
	public IUserRepository iUserRepository() {
		return new UserRepositoryImpl();
	}

	@Bean
	public IUserService iUserService(IUserRepository iUserRepository) {
		return new UserServiceImpl(iUserRepository);
	}
}
