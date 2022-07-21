package bekmax.phase2.repository;

import bekmax.phase2.dto.CourseDto;
import bekmax.phase2.dto.StudentDto;
import bekmax.phase2.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();
    private long id = 1;

    public List<StudentDto> getStudents() {
        return students.stream()
                .filter(s -> !s.isDeleted())
                .map(s -> new StudentDto(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail(), s.getMajor(), s.getGpa(), s.getCoursesTaken()))
                .collect(Collectors.toList());
    }

    public StudentDto save(StudentDto s) {
        Student student = new Student(id++, s.getFirstName(), s.getLastName(), s.getEmail(), s.getMajor(), s.getGpa(), s.getCoursesTaken(), false);
        s.setId(student.getId());
        students.add(student);
        return s;
    }

    public void delete(long id) {
        var student = students.stream().filter(s -> s.getId() == id).findFirst();
        student.ifPresent(s -> s.setDeleted(true));
    }

    public void update(long id, StudentDto newStudent) {
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

    public List<StudentDto> getByMajor(String major) {
        return getStudents()
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<CourseDto> getCoursesByStudentId(long id) {
        var studentDto = getStudents().stream().filter(s -> s.getId() == id).findFirst();
        if (studentDto.isPresent()){
            List<CourseDto> courseDtoList = new ArrayList<>();
            studentDto.get().getCoursesTaken().forEach(c ->{
                courseDtoList.add(new CourseDto(c.getId(), c.getName(), c.getCode()));
            });
            return courseDtoList;
        }
        return null;
    }
}
