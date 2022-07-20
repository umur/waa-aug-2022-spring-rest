package waa.phase3.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }


}
