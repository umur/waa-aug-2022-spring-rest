package waa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    private Integer id;
    private String name;
    private String code;
}