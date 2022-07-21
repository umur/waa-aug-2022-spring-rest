package lab.waa.two.phase1.mapper;

import lab.waa.two.phase1.dto.CourseDto;
import lab.waa.two.phase1.dto.StudentDto;
import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentMapper {
  private final ModelMapper modelMapper;

  public StudentDto toDTO(Student student) {
    return modelMapper.map(student, StudentDto.class);
  }

  public Student toStudent(StudentDto dto) {
    return modelMapper.map(dto, Student.class);
  }
}
