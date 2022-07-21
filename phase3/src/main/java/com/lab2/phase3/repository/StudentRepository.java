package com.lab2.phase3.repository;

import com.lab2.phase3.entity.Course;
import com.lab2.phase3.entity.Student;
import com.lab2.phase3.exception.StudentNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>();

    private static int id = 1;

    private static int getId() {
        return id;
    }

    private static void setId(int id) {
        StudentRepository.id = id;
    }


    public List<Student> findAll() {
        return students;
    }

    public void save(Student student) {
        student.setId(id);
        this.setId(id + 1);
        students.add(student);
    }

    public boolean delete(int id) {
        return students.removeIf(student -> student.getId() == id);
    }

    public Student findById(int id) {
        Student student = students.stream()
                .filter(s -> s.getId() == id)
                .findAny()
                .orElse(null);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        return student;
    }

    public void update(int id, Student student) {
        Student studentAsked = students.stream()
                .filter(s -> s.getId() == id)
                .findAny()
                .orElse(null);
        if (studentAsked == null) {
            throw new StudentNotFoundException();
        }
        student.setId(id);
        students.set(students.indexOf(studentAsked), student);
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        Student student = students.stream().filter(s -> s.getId() == studentId).findAny().orElse(null);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        return student.getCoursesTaken();
    }
}
