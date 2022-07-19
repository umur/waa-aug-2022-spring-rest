package lab2.phase1.service;

import lab2.phase1.domain.Course;
import lab2.phase1.domain.Student;

import java.util.List;

public interface ICourseService {
    Boolean create(Course stu);
    List<Course> read();
    Boolean update(int id, Course stu);
    Boolean delete(int id);
}
