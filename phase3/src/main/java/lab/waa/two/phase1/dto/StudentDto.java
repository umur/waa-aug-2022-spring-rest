package lab.waa.two.phase1.dto;

import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

  private Long id;

  private String firstname;

  private String lastname;

  private String email;

  private String major;

  private Double gpa;

  private List<Course> coursesTaken;


  public static StudentDto toDTO(Student student) {
    StudentDto dto = new StudentDto();
    dto.setId(student.getId());
    dto.setFirstname(student.getFirstName());
    dto.setLastname(student.getLastName());
    dto.setEmail(student.getEmail());
    dto.setMajor(student.getMajor());
    dto.setGpa(student.getGpa());
    dto.setCoursesTaken(student.getCoursesTaken());
    return dto;
  }

  public static Student toStudent(StudentDto dto) {
    Student student = new Student();
    student.setId(dto.getId());
    student.setFirstName(dto.getFirstname());
    student.setLastName(dto.getLastname());
    student.setEmail(dto.getEmail());
    student.setMajor(dto.getMajor());
    student.setGpa(dto.getGpa());
    student.setCoursesTaken(dto.getCoursesTaken());
    return student;
  }

}
