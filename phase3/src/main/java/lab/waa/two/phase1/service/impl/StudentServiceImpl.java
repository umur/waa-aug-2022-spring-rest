package lab.waa.two.phase1.service.impl;

import lab.waa.two.phase1.dto.CourseDto;
import lab.waa.two.phase1.dto.StudentDto;
import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.mapper.CourseMapper;
import lab.waa.two.phase1.mapper.StudentMapper;
import lab.waa.two.phase1.repository.StudentRepo;
import lab.waa.two.phase1.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepo studentRepo;
  private final StudentMapper studentMapper;
  private final CourseMapper courseMapper;

  @Override
  public void save(StudentDto studentDto) {
    studentRepo.save(studentMapper.toStudent(studentDto));
  }

  @Override
  public void delete(Long id) {
    studentRepo.delete(id);
  }

  @Override
  public void update(Long id, StudentDto studentDto) {
    studentRepo.update(id, studentMapper.toStudent(studentDto));
  }

  @Override
  public List<StudentDto> getAll() {
    return studentRepo.getAll()
      .stream()
      .map(studentMapper::toDTO)
      .collect(Collectors.toList());
  }

  @Override
  public StudentDto getById(Long id) {
    return studentMapper.toDTO(studentRepo.getById(id));
  }

  @Override
  public List<StudentDto> getStudentsByMajor(String major) {

    return studentRepo.getStudentsByMajor(major)
      .stream()
      .map(studentMapper::toDTO)
      .collect(Collectors.toList());
  }

  @Override
  public List<CourseDto> getCoursesByStudentId(Long id) {
    return studentRepo.getCoursesByStudentId(id)
      .stream()
      .map(courseMapper::toDTO)
      .collect(Collectors.toList());
  }

}
