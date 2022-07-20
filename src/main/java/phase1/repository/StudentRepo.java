package phase1.repository;

import org.springframework.stereotype.Repository;
import phase1.entity.Course;
import phase1.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static final List<Student> students = new ArrayList<>();
    private int idCounter = 1;

    public List<Student> getStudents() {
        return students
                .stream()
                .filter(s -> !s.isDeleted())
                .collect(Collectors.toList());
    }

    public Student save(Student s) {
        s.setId(idCounter);
        idCounter++;
        students.add(s);
        return s;
    }

    public void delete(int studentId) {
        var foundStudent = students.stream().filter(s -> s.getId() == studentId).findFirst();
        foundStudent.ifPresent(student -> student.setDeleted(true));
    }

    public void update(int studentId, Student s) {
        var foundStudent = students.stream().filter(stu -> stu.getId() == studentId).findFirst();
        if (foundStudent.isPresent()) {
            if (s.getFirstName() != null && !s.getFirstName().isEmpty()) {
                foundStudent.get().setFirstName(s.getFirstName());
            }
            if (s.getLastName() != null && !s.getLastName().isEmpty()) {
                foundStudent.get().setLastName(s.getLastName());
            }

            if (s.getEmail() != null && !s.getEmail().isEmpty()) {
                foundStudent.get().setEmail(s.getEmail());
            }

            if (s.getMajor() != null && !s.getMajor().isEmpty()) {
                foundStudent.get().setMajor(s.getMajor());
            }

            if (s.getGpa() != null) {
                foundStudent.get().setGpa(s.getGpa());
            }

            if (s.getCoursesTaken() != null) {
                foundStudent.get().setCoursesTaken(s.getCoursesTaken());
            }
        }
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
