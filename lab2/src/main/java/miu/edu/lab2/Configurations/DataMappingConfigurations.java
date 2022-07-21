package miu.edu.lab2.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataMappingConfigurations {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
