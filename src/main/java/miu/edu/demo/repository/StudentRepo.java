package miu.edu.demo.repository;

import miu.edu.demo.entity.Course;
import miu.edu.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private List<Student> studentList = new ArrayList<>();

    public void save(Student student) {
        studentList.add(student);
    }

    public List<Student> findAll(){
        return studentList
                .stream()
                .filter(student -> !student.isDeleted())
                .collect(Collectors.toList());
    }

    public Optional<Student> findById(int id) {
        return studentList
                .stream()
                .filter(student -> Objects.equals(student.getId(), id))
                .findFirst();
    }

    public void deleteStudent(int id) {
        studentList.remove(id);
    }

    public void updateStudent(int id, Student student) {
        studentList.set(id, student);
    }

    public List<Student> filterStudents(Predicate<Student> predicate) {
        return studentList
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Student addCourse(int studentId, Course course){
        Student student = findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("No such student with id: " + studentId));
        student.getCoursesTaken().add(course);
        return student;
    }
}
