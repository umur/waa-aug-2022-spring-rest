package edu.miu.RestDemoApplication.repository;

import edu.miu.RestDemoApplication.entity.Course;
import edu.miu.RestDemoApplication.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    static long id = 3;
    private static List<Student> students = new ArrayList<>();

    public StudentRepo() {
        Course c1 = new Course(1, "WAA", "CS545", false);
        Course c2 = new Course(2, "Algorithms", "CS432", false);

        List<Course> courses = List.of(c1, c2);

        Student s1 = new Student(1, "Ozod", "Tagoev", "ozod.tagoev@gmail.com", "ComPro", courses, 4.0, false);
        Student s2 = new Student(2, "Muhammad", "Shakhtour", "mohd2@gmail.com", "ComPro", courses, 4.0, false);

        students.addAll(List.of(s1, s2));
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findByID(long id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
    }

    public Student addStudent(Student student) {
        student.setId(id);
        students.add(student);
        id++;
        return student;
    }

    public Student updateStudent(Student student) {
        long id = student.getId();
        Student studentReference = findByID(id);
        studentReference.setFirstName(student.getFirstName());
        studentReference.setLastName(student.getLastName());
        studentReference.setCoursesTaken(student.getCoursesTaken());
        studentReference.setGpa(student.getGpa());
        studentReference.setMajor(student.getMajor());
        studentReference.setEmail(student.getEmail());
        return studentReference;
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentID(long id) {
        Student student = findByID(id);
        return student.getCoursesTaken();
    }

    public void removeStudentByID(long id) {
        Student student = findByID(id);
        students.remove(student);
    }
}
