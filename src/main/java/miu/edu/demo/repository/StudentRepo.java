package miu.edu.demo.repository;

import miu.edu.demo.entity.Course;
import miu.edu.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Student student1 = studentList
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such student with id: " + id));
        student1.setDeleted(true);
    }

    public void updateStudent(int id, Student student) {
        int index = IntStream.range(0, studentList.size()-1)
                .filter(i -> studentList.get(i).getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such student with id: " + id));

        studentList.set(index, student);
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
