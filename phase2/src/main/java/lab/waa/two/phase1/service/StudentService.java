package lab.waa.two.phase1.service;

import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
  void save(Student student);

  void delete(Long id);

  void update(Long id, Student student);

  List<Student> getAll();

  Student getById(Long id);

  List<Student> getStudentsByMajor(String major);

  List<Course> getCoursesByStudentId(Long id);
}
