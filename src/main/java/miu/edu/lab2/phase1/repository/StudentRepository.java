package miu.edu.lab2.phase1.repository;

import miu.edu.lab2.phase1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>();
    private static int idCounter = 1;

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int studentId){
        return students.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst().orElse(null);
    }

    public void save(Student student) {
        student.setId(idCounter++);
        students.add(student);
    }

    public Student update(Student student) throws Exception {
        int id = student.getId();
        Student std = findById(id);

        if(std == null) {
            throw new Exception("Student not found");
        }

        std.setEmail(student.getEmail());
        std.setCoursesTaken(student.getCoursesTaken());
        std.setFirstName(student.getFirstName());
        std.setGpa(student.getGpa());
        std.setMajor(student.getMajor());

        return std;
    }

    public Student delete(int studentId) throws Exception {
        Student std = findById(studentId);
        if(std == null) {
            throw new Exception("Student not found");
        }
        students.remove(std);
        return std;
    }

    public List<Student> findByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());
    }
}
