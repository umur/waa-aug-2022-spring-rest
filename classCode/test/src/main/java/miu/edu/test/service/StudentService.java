package miu.edu.test.service;

import miu.edu.test.dto.CourseDto;
import miu.edu.test.dto.StudentCreateDto;
import miu.edu.test.dto.StudentDto;
import miu.edu.test.entity.Course;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();
    StudentDto getStudent(int id);
    StudentDto create(StudentCreateDto student);

    StudentDto delete(int id);

    StudentDto update(int id, StudentCreateDto stu);
    List<StudentDto> getStudentsByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int studentId);
}
