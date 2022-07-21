package lab.waa.two.phase1.service;

import lab.waa.two.phase1.dto.CourseDto;
import lab.waa.two.phase1.dto.StudentDto;
import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
  void save(StudentDto studentDto);

  void delete(Long id);

  void update(Long id, StudentDto studentDto);

  List<StudentDto> getAll();

  StudentDto getById(Long id);

  List<StudentDto> getStudentsByMajor(String major);

  List<CourseDto> getCoursesByStudentId(Long id);
}
