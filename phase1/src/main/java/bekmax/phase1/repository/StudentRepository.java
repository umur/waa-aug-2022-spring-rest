package bekmax.phase1.repository;

import bekmax.phase1.model.Course;
import bekmax.phase1.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();
    private long id = 1;

    public List<Student> getStudents() {
        return students.stream().filter(s -> !s.isDeleted()).collect(Collectors.toList());
    }

    public Student save(Student student) {
        student.setId(id++);
        students.add(student);
        return student;
    }

    public void delete(long id) {
        var student = students.stream().filter(s -> s.getId() == id).findFirst();
        student.ifPresent(s -> s.setDeleted(true));
    }

    public void update(long id, Student newStudent) {
        var student = students.stream().filter(s -> s.getId() == id).findFirst();
        if (student.isPresent()) {
            if (newStudent.getFirstName() != null && !newStudent.getFirstName().isEmpty()) {
                student.get().setFirstName(newStudent.getFirstName());
            }
            if (newStudent.getLastName() != null && !newStudent.getLastName().isEmpty()) {
                student.get().setLastName(newStudent.getLastName());
            }

            if (newStudent.getEmail() != null && !newStudent.getEmail().isEmpty()) {
                student.get().setEmail(newStudent.getEmail());
            }

            if (newStudent.getMajor() != null && !newStudent.getMajor().isEmpty()) {
                student.get().setMajor(newStudent.getMajor());
            }

            if (newStudent.getGpa() != null) {
                student.get().setGpa(newStudent.getGpa());
            }

            if (newStudent.getCoursesTaken() != null) {
                student.get().setCoursesTaken(newStudent.getCoursesTaken());
            }
        }
    }

    public List<Student> getByMajor(String major) {
        return students
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(long id) {
        var student = students.stream().filter(s -> s.getId() == id).findFirst();
        return student.map(Student::getCoursesTaken).orElse(null);
    }
}
