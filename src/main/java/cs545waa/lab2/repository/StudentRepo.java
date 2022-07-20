package cs545waa.lab2.repository;

import cs545waa.lab2.entity.Course;
import cs545waa.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static final List<Student> students = new ArrayList<>();

    public static List<Student> getStudents() {
        return students
                .stream()
                .filter(s -> !s.isDeleted())
                .collect(Collectors.toList());
    }

    public void save(Student s) {
        students.add(s);
    }

    public void delete(int studentId) {
        var foundStudent = students.stream().filter(s -> s.getId() == studentId).findFirst();
        foundStudent.ifPresent(students::remove);
    }

    public List<Student> getByMajor(String major) {
        return getStudents()
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        var foundStudent = getStudents()
                .stream()
                .filter(s -> s.getId() == studentId).findFirst();
        return foundStudent.map(Student::getCoursesTaken).orElse(null);
    }
}
