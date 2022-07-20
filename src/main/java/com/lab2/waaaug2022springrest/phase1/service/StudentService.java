package com.lab2.waaaug2022springrest.phase1.service;

import com.lab2.waaaug2022springrest.phase1.entity.Course;
import com.lab2.waaaug2022springrest.phase1.entity.Student;
import com.lab2.waaaug2022springrest.phase1.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(Student student) {
      return studentRepository.createOne(student);
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findOneById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(int studentId, Student student) throws IllegalStateException {
        return studentRepository.updateOne(studentId, student);
    }

    public void deleteStudent(int studentId) throws IllegalStateException {
        studentRepository.deleteOne(studentId);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
}
