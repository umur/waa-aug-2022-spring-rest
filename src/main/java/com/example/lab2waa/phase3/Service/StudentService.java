package com.example.lab2waa.phase3.Service;

import com.example.lab2waa.phase3.Model.Course;
import com.example.lab2waa.phase3.Model.Student;
import com.example.lab2waa.phase3.dto.StudentDto;

import java.util.List;


public interface StudentService {

    public List<StudentDto> findAll() ;

    public Student findById(int id) ;

    public List<StudentDto> getStudentsByMajor(String major) ;

    public List<Course> getCoursesByStudentId(int id);

    public Student addStudent(StudentDto studentDto) ;

    public Student updateStudent(StudentDto studentDto) ;

    public void deleteStudent(int id) ;

}
