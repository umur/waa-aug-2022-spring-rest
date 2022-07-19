package lab2.phase1.repository;

import lab2.phase1.domain.Course;
import lab2.phase1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> arr = new ArrayList<>();
    private static int idCounter = 1;

    public Boolean create(Student stu) {
        stu.setId(idCounter++);
        arr.add(stu);
        return true;
    }

    public List<Student> read() {
        return arr;
    }

    public Boolean update(int id, Student stu) {
        Optional<Student> data = arr.stream().filter(e -> e.getId() == id).findFirst();
        if (data.isPresent()) {
            arr.set(arr.indexOf(data.get()), stu);
            return true;
        }
        return false;
    }

    public Boolean delete(int id) {
        Optional<Student> data = arr.stream().filter(e -> e.getId() == id).findFirst();
        if (data.isPresent()) {
            arr.remove(data.get());
            return true;
        }
        return false;
    }

    public List<Student> getStudentsByMajor(String major) {
        return arr.stream()
                .filter(e -> e.getMajor() == major)
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return arr.stream()
                .filter(e -> e.getId() == studentId)
                .flatMap(e -> e.getCoursesTaken().stream())
                .collect(Collectors.toList());
    }
}
