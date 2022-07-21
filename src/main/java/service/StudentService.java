package service;

import domain.Course;
import domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();
    void create(Student student);
    void delete(int id);
    List<Student> findByMajor(String major);
    List<Course> findByCourses(int id);

}
