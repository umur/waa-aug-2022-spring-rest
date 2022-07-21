package miu.edu.lab2;

import miu.edu.lab2.repositories.CourseRepo;
import miu.edu.lab2.repositories.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
		CourseRepo.main(args);
		StudentRepo.main(args);
	}

}
