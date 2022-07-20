package phase2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phase2.dto.CourseDto;
import phase2.dto.StudentDto;
import phase2.entity.Course;
import phase2.entity.Student;
import phase2.repository.StudentRepo;
import phase2.service.StudentService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public List<StudentDto> findAll() {
        return studentRepo.getStudents();
    }

    public StudentDto save(StudentDto s) {
        return studentRepo.save(s);
    }

    public void delete(int studentId) {
        studentRepo.delete(studentId);
    }

    public void update(int studentId, StudentDto s) {
        studentRepo.update(studentId, s);
    }

    public List<StudentDto> getByMajor(String major) {
        return studentRepo.getByMajor(major);
    }

    public List<CourseDto> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
