package waa.phase2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.phase2.dto.StudentDto;
import waa.phase2.entity.Course;
import waa.phase2.entity.Student;
import waa.phase2.repository.StudentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public List<StudentDto> findAll() {
        var students = studentRepo.findAll();
        var result = new ArrayList<StudentDto>();
        students.forEach(student -> {
            result.add(new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getMajor(), student.getGpa(), student.getCoursesTaken()));
        });
        return result;
    }

    @Override
    public void save(StudentDto student) {
        studentRepo.save(new Student(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getMajor(), student.getGpa(), student.getCoursesTaken(), false));
    }

    @Override
    public void deleteById(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void update(int id, StudentDto student) {
        studentRepo.update(id, new Student(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getMajor(), student.getGpa(), student.getCoursesTaken(), false));
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        Student result = studentRepo.findAll().stream().filter(stu -> stu.getId() == studentId).collect(Collectors.toList()).get(0);
        return result.getCoursesTaken();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.findAll().stream().filter(stu -> stu.getMajor().equalsIgnoreCase(major)).collect(Collectors.toList());
    }
}

