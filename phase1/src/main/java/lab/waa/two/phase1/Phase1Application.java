package lab.waa.two.phase1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Phase1Application {

	public static void main(String[] args) {
		SpringApplication.run(Phase1Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
	  return new ModelMapper();
  }

}
