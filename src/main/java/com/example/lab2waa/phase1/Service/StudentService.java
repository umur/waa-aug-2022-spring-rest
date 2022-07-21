package com.example.lab2waa.phase1.Service;

import com.example.lab2waa.phase1.Model.Course;
import com.example.lab2waa.phase1.Model.Student;
import com.example.lab2waa.phase1.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    public List<Student> findAll() ;

    public Student findById(int id) ;

    public List<Student> getStudentsByMajor(String major) ;

    public List<Course> getCoursesByStudentId(int id);

    public Student addStudent(Student student) ;

    public Student updateStudent(Student student) ;

    public void deleteStudent(int id) ;

}
