package phase3.repository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import phase3.dto.CourseDto;
import phase3.dto.StudentDto;
import phase3.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StudentRepo {
    private static final List<Student> students = new ArrayList<>();
    private int idCounter = 1;
    private final ModelMapper modelMapper;

    public List<StudentDto> getStudents() {
        return students
                .stream()
                .filter(s -> !s.isDeleted())
                .map(s -> modelMapper.map(s, StudentDto.class))
                .collect(Collectors.toList());
    }

    public StudentDto save(StudentDto sd) {
        Student s = modelMapper.map(sd, Student.class);
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
                result.add(modelMapper.map(c, CourseDto.class));
            });
            return result;
        }
        return null;
    }
}
