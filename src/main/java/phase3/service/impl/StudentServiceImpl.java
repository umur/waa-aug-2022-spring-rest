package phase3.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phase3.dto.CourseDto;
import phase3.dto.StudentDto;
import phase3.repository.StudentRepo;
import phase3.service.StudentService;

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
