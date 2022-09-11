package com.supportportal;

import static com.supportportal.constant.FileConstant.USER_FOLDER;

import java.io.File;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SupportportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportportalApplication.class, args);
		new File(USER_FOLDER).mkdirs();
	}

	@Bean
	   public CorsFilter corsFilter() {
	           UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	           CorsConfiguration configuration = new CorsConfiguration();
	           configuration.setAllowedOrigins(Arrays.asList("*","http://localhost:4200/"));
	       configuration.setAllowCredentials(true);
	       configuration.setAllowedHeaders(Arrays.asList(
	                       "Access-Control-Allow-Headers",
	                       "Access-Control-Allow-Origin",
	                       "Access-Control-Request-Method",
	                       "Access-Control-Request-Headers",
	                       "Origin",
	                       "Cache-Control",
	                       "Content-Type",
	                       "Jwt-Token",
	                       "Authorization"));
	       configuration.setExposedHeaders(Arrays.asList(
	                       "Origin",
	                       "Cache-Control",
	                       "Content-Type",
	                       "Jwt-Token",
	                       "Authorization",
	                       "Access-Control-Allow-Headers",
	                       "Access-Control-Allow-Origin",
	                       "Access-Control-Request-Method",
	                       "Access-Control-Request-Headers"));
	       configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
	 
	               source.registerCorsConfiguration("/**", configuration);
	       return new CorsFilter(source);
	       }

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
