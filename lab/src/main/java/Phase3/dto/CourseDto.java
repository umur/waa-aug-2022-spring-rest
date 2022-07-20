package Phase3.dto;

;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class CourseDto {
    int id;
    String name;
    String code;

//    CourseDto toCourseDto(Course course) {
//        CourseDto courseDto = new CourseDto();
//        courseDto.setId(course.getId());
//        courseDto.setName(course.getName());
//        courseDto.setCode(course.getCode());
//
//        return courseDto;
//    }
//
//    Course toCourse() {
//        return new Course(this.id, this.name, this.code);
//    }
}