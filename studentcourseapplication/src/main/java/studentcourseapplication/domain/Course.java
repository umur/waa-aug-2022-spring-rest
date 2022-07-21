package studentcourseapplication.domain;

import lombok.Data;

@Data
public class Course {
    private Long id ;
    private String name;
    private String code;

    public Course(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }


}
