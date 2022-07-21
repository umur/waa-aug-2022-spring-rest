package lab.waa.two.phase1.dto;

import lab.waa.two.phase1.entity.Course;
import lombok.Data;

@Data
public class CourseDto {

  private Long id;

  private String name;

  private String code;

  public static CourseDto toDTO(Course course) {
    CourseDto dto = new CourseDto();
    dto.setId(course.getId());
    dto.setName(course.getName());
    dto.setCode(course.getCode());
    return dto;
  }

  public static Course toCourse(CourseDto dto) {
    Course course = new Course();
    course.setId(dto.getId());
    course.setName(dto.getName());
    course.setCode(dto.getCode());
    return course;
  }

}
