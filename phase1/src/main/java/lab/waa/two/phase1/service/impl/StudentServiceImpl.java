package lab.waa.two.phase1.service.impl;

import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
import lab.waa.two.phase1.repository.StudentRepo;
import lab.waa.two.phase1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepo studentRepo;

  @Override
  public void save(Student student) {
    studentRepo.save(student);
  }

  @Override
  public void delete(Long id) {
    studentRepo.delete(id);

  }

  @Override
  public void update(Long id, Student student) {
    studentRepo.update(id, student);
  }

  @Override
  public List<Student> getAll() {
    return studentRepo.getAll();
  }

  @Override
  public Student getById(Long id) {
    return studentRepo.findById(id);
  }

  @Override
  public List<Student> getStudentsByMajor(String major) {
    return studentRepo.getStudentsByMajor(major);
  }

  @Override
  public List<Course> getCoursesByStudentId(Long id) {
    return studentRepo.getCoursesByStudentId(id);
  }

}
