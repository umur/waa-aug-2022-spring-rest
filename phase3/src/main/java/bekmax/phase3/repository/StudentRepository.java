package bekmax.phase3.repository;

import bekmax.phase3.dto.CourseDto;
import bekmax.phase3.dto.StudentDto;
import bekmax.phase3.model.Course;
import bekmax.phase3.model.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();
    private long id = 1;
    private final ModelMapper modelMapper;

    public List<StudentDto> getStudents() {
        return students.stream()
                .filter(s -> !s.isDeleted())
                .map(s -> modelMapper.map(s, StudentDto.class))
                .collect(Collectors.toList());
    }

    public StudentDto save(StudentDto sd) {
        Student student = modelMapper.map(sd, Student.class);
        student.setId(id++);
        sd.setId(student.getId());
        students.add(student);
        return sd;
    }

    public void delete(long id) {
        var student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        student.ifPresent(s -> s.setDeleted(true));
    }

    public void update(long id, StudentDto sd) {
        var student = students.stream()
                .filter(stu -> stu.getId() == id)
                .findFirst();
        if (student.isPresent()) {
            if (sd.getFirstName() != null && !sd.getFirstName().isEmpty()) {
                student.get().setFirstName(sd.getFirstName());
            }
            if (sd.getLastName() != null && !sd.getLastName().isEmpty()) {
                student.get().setLastName(sd.getLastName());
            }

            if (sd.getEmail() != null && !sd.getEmail().isEmpty()) {
                student.get().setEmail(sd.getEmail());
            }

            if (sd.getMajor() != null && !sd.getMajor().isEmpty()) {
                student.get().setMajor(sd.getMajor());
            }

            if (sd.getGpa() != null) {
                student.get().setGpa(sd.getGpa());
            }

            if (sd.getCoursesTaken() != null) {
                List<Course> courseList = new ArrayList<>();
                sd.getCoursesTaken().forEach(courseDto -> {
                    courseList.add(modelMapper.map(courseDto, Course.class));
                });
                student.get().setCoursesTaken(courseList);
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
        var student = getStudents()
                .stream()
                .filter(s -> s.getId() == id).findFirst();
        if (student.isPresent()) {
            List<CourseDto> result = new ArrayList<>();
            student.get().getCoursesTaken().forEach(c -> {
                result.add(modelMapper.map(c, CourseDto.class));
            });
            return result;
        }
        return null;
    }
}
