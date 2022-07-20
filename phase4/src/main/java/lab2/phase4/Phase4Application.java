package lab2.phase4;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Phase4Application {

    public static void main(String[] args) {
        SpringApplication.run(Phase4Application.class, args);
    }

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
