package miu.edu.test.dto;

import lombok.Data;
import miu.edu.test.entity.Course;

import java.util.List;

@Data
public class StudentCreateDto {
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Integer> coursesTaken;
}
