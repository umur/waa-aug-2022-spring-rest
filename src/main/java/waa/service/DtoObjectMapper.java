package waa.service;

import org.springframework.stereotype.Component;
import waa.domain.Course;
import waa.domain.Student;
import waa.dto.CourseDTO;
import waa.dto.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoObjectMapper {

    public Student getStudentFromStudentDTO(StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail(),
                studentDTO.getMajor(),
                getCoursesList(studentDTO.getCoursesTaken()),
                studentDTO.getGpa());
        return student;
    }


    public List<Course> getCoursesList(List<CourseDTO> courseDTOs) {
        List<Course> courses = courseDTOs.stream()
                .map(c->new Course(c.getId(), c.getName(), c.getCode()))
                .collect(Collectors.toList());
        return courses;
    }

    public StudentDTO getStudentDTOFromStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO(student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getMajor(),
                getCourseDTOList(student.getCoursesTaken()),
                student.getGpa());
        return studentDTO;
    }

    public List<CourseDTO> getCourseDTOList(List<Course> courses) {
        List<CourseDTO> courseDTOs = courses.stream()
                .map(c->new CourseDTO(c.getId(), c.getName(), c.getCode()))
                .collect(Collectors.toList());
        return courseDTOs;
    }

    public List<Student> getStudentList(List<StudentDTO> studentDTOs) {
        List<Student> students = studentDTOs.stream().map(s->getStudentFromStudentDTO(s)).collect(Collectors.toList());
        return students;
    }

    public List<StudentDTO>  getStudentDTOs(List<Student> students) {
        List<StudentDTO> studentDTOs = students.stream().map(s->getStudentDTOFromStudent(s)).collect(Collectors.toList());
        return  studentDTOs;
    }

}

