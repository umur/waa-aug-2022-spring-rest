package com.example.lab2waa.phase3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;


//@SpringBootApplication
public class Lab2WaaApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab2WaaApplication.class, args);
    }

}
