package studentcourseapplication.dtos;

import lombok.Data;
import studentcourseapplication.domain.Course;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDTO {
    private Long id ;
    private String name;
    private String code;

    public CourseDTO(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public class CourseAdapter{
        public static CourseDTO getCourseDTOFromCourse(Course course){
            return new CourseDTO(course.getId(),course.getName(),course.getCode());
        }
        public static Course getCourseFromCourseDTO(CourseDTO courseDTO){
            return new Course(courseDTO.getId(),courseDTO.getName(),courseDTO.getCode());
        }

        public static List<CourseDTO> getCourseDTOListFromCourseList(List<Course> courseList){
            List<CourseDTO> courseDTOS = new ArrayList<>();
            courseList.stream().map(e -> courseDTOS.add(getCourseDTOFromCourse(e)) );
            return courseDTOS;
        }
    }
}
