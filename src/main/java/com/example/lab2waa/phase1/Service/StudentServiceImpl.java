package com.example.lab2waa.phase1.Service;

import com.example.lab2waa.phase1.Model.Course;
import com.example.lab2waa.phase1.Model.Student;
import com.example.lab2waa.phase1.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }
}
