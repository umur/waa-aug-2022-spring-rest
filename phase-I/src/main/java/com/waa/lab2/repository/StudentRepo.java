package com.waa.lab2.repository;


import com.waa.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    static List<Student> students = new ArrayList<>();

    {
        // Init sample data
        students.add(new Student(1L, "John", "Nathan",
                "jonh.nathan@gmail.com", "CS", Arrays.asList(CourseRepo.courses.get(0)), false));
        students.add(new Student(2L, "Jack", "Dallas",
                "jack.Dallas@gmail.com", "Math", Arrays.asList(CourseRepo.courses.get(1)), false));
    }

    public List<Student> findAll() {
        return students
                .stream()
                .filter(c -> !c.isDeleted())
                .collect(Collectors.toList());
    }

    public void save(Student student) {
        students.add(student);
    }

    public void update(Student student) {
        students
                .stream()
                .filter(c -> !c.isDeleted())
                .filter(c -> c.getId().equals(student.getId()))
                .forEach(c -> {
                    c.setFirstName(student.getFirstName());
                    c.setLastName(student.getLastName());
                    c.setEmail(student.getEmail());
                    c.setMajor(student.getMajor());
                    c.setCoursesTaken(student.getCoursesTaken());
                });
    }

    public void deleteById(Long id) {
        students
                .stream()
                .filter(c -> c.getId().equals(id))
                .forEach(c -> c.setDeleted(true));
    }

    public Optional<Student> findById(Long id) {
        return students
                .stream()
                .filter(c -> !c.isDeleted())
                .filter(c -> c.getId().equals(id))
                .findAny();
    }

    public List<Student> getByMajor(String major) {
        return students
                .stream()
                .filter(c -> !c.isDeleted())
                .filter(c -> c.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

}
