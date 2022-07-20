package com.lab2.waaaug2022springrest.phase3.repository;

import com.lab2.waaaug2022springrest.phase3.entity.Course;
import com.lab2.waaaug2022springrest.phase3.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    public static List<Student> students = new ArrayList<>();
    private static int id = 1;

    public List<Student> findAll() {
        return students;
    }

    public Student createOne(Student student) {
        student.setId(id++);
        students.add(student);
        return student;
    }

    public Student findOneById(int studentId) {
        return students.stream().filter(student -> student.getId() == studentId).findFirst().orElse(null);
    }

    public Student updateOne(int studentId, Student student) {
        Student existing_student = findOneById(studentId);

        if(existing_student == null) {
            throw new IllegalStateException("student not found!");
        }

        existing_student.setEmail(student.getEmail());
        existing_student.setCoursesTaken(student.getCoursesTaken());
        existing_student.setFirstName(student.getFirstName());
        existing_student.setGpa(student.getGpa());
        existing_student.setMajor(student.getMajor());

        return existing_student;
    }

    public void deleteOne(int id) {
        Student student = findOneById(id);
        if(student == null) throw new IllegalStateException("student not found!");
        students.remove(student);
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        Student student = findOneById(studentId);
        if(student == null) throw new IllegalStateException("student not found!");
        return student.getCoursesTaken();
    }

}
