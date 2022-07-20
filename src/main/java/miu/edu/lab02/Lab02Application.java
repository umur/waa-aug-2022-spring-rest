package miu.edu.lab02;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Lab02Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab02Application.class, args);
	}

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
}
