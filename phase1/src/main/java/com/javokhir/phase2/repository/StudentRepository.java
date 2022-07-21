package com.javokhir.phase2.repository;

import com.javokhir.phase1.domain.Course;
import com.javokhir.phase1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private static final List<Student> students = new ArrayList<>();

    public List<Student> getAll(){
        return students;
    }

    public Optional<Student> getById(UUID id){
        return students.stream().filter(t -> t.getId().equals(id)).findAny();
    }

    public Student create(Student student){
        student.setId(UUID.randomUUID());
        students.add(student);
        return student;
    }

    public Student update(Student student){
        Student dbStudent = students.stream().filter(t -> t.getId().equals(student.getId())).findAny().orElseThrow();

        dbStudent.setFirstName(student.getFirstName());
        dbStudent.setLastName(student.getLastName());
        dbStudent.setEmail(student.getEmail());
        dbStudent.setMajor(student.getMajor());
        dbStudent.setGpa(student.getGpa());
        dbStudent.setCoursesTaken(student.getCoursesTaken());

        return dbStudent;
    }

    public void remove(UUID id){
        students.stream().filter(t -> t.getId().equals(id)).findAny().ifPresent(students::remove);
    }

    public List<Student> findStudentsByMajor(String major){
        return students.stream()
                .filter(t -> t.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    public List<Course> findCoursesByStudentId(UUID id){
        return students.stream().filter(t -> t.getId().equals(id))
                .findAny()
                .map(Student::getCoursesTaken)
                .orElse(Collections.emptyList());
    }
}
