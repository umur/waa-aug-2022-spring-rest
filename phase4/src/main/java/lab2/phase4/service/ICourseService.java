package lab2.phase4.service;

import lab2.phase4.domain.Course;
import lab2.phase4.domain.Student;
import lab2.phase4.dto.CourseDTO;

import java.util.List;

public interface ICourseService {
    Boolean create(CourseDTO stu);
    List<CourseDTO> read();
    Boolean update(int id, CourseDTO stu);
    Boolean delete(int id);
}
