package phase2.repository;

import org.springframework.stereotype.Repository;
import phase2.dto.CourseDto;
import phase2.dto.StudentDto;
import phase2.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static final List<Student> students = new ArrayList<>();
    private int idCounter = 1;

    public List<StudentDto> getStudents() {
        return students
                .stream()
                .filter(s -> !s.isDeleted())
                .map(s -> new StudentDto(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail(), s.getMajor(), s.getGpa(), s.getCoursesTaken()))
                .collect(Collectors.toList());
    }

    public StudentDto save(StudentDto sd) {
        Student s = new Student(sd.getId(), sd.getFirstName(), sd.getLastName(), sd.getEmail(), sd.getMajor(), sd.getGpa(), sd.getCoursesTaken(), false);
        s.setId(idCounter);
        sd.setId(idCounter);
        idCounter++;
        students.add(s);
        return sd;
    }

    public void delete(int studentId) {
        var foundStudent = students.stream().filter(s -> s.getId() == studentId).findFirst();
        foundStudent.ifPresent(student -> student.setDeleted(true));
    }

    public void update(int studentId, StudentDto s) {
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

    public List<StudentDto> getByMajor(String major) {
        return getStudents()
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<CourseDto> getCoursesByStudentId(int studentId) {
        var foundStudent = getStudents()
                .stream()
                .filter(s -> s.getId() == studentId).findFirst();
        if (foundStudent.isPresent()) {
            List<CourseDto> result = new ArrayList<>();
            foundStudent.get().getCoursesTaken().forEach(c -> {
                result.add(new CourseDto(c.getId(), c.getName(), c.getCode()));
            });
            return result;
        }
        return null;
    }
}
