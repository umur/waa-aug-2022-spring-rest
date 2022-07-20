package miu.edu.lab02.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CourseDTO {
    private Integer id;
    String name;
    String code;
}
