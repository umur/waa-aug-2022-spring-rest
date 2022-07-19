package lab2.phase1.repository;

import lab2.phase1.domain.Course;
import lab2.phase1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> arr = new ArrayList<>();

    public List<Student> getStudentsByMajor(String major) {
        return arr.stream()
                .filter(e -> e.getMajor() == major)
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId)
    {
        return arr.stream()
                .filter(e->e.getId() == studentId)
                .flatMap(e->e.getCoursesTaken().stream())
                .collect(Collectors.toList());
    }
}
