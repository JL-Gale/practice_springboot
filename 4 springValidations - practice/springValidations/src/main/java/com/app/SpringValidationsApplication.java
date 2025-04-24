package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
//@PropertySource("classpath:messsages.properties")
public class SpringValidationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringValidationsApplication.class, args);

	}
		@Bean
		public LocaleResolver localeResolver() {
			SessionLocaleResolver slr = new SessionLocaleResolver();
			slr.setDefaultLocale(Locale.ENGLISH); // Aquí fijas el idioma
			return slr;
		}
}
