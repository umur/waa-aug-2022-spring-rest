package miu.edu.lab2.services;

import miu.edu.lab2.dtos.CourseDto;
import miu.edu.lab2.dtos.StudentDto;
import miu.edu.lab2.models.Course;
import miu.edu.lab2.models.Student;

import java.util.List;

public interface StudentService {
    public List<StudentDto> getAll();
    public void save(StudentDto studentDto);
    public void delete(StudentDto studentDto);

    public List<StudentDto> getStudentByMajor(String major);

    public List<CourseDto> getCoursesByStudentId(int studentId);
}
