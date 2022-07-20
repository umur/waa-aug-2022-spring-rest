package miu.edu.lab2.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTO {
    int id;
    String name;
    String code;
}
