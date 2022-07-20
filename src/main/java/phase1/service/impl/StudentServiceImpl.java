package phase1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phase1.entity.Course;
import phase1.entity.Student;
import phase1.repository.StudentRepo;
import phase1.service.StudentService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public List<Student> findAll() {
        return studentRepo.getStudents();
    }

    public Student save(Student s) {
        return studentRepo.save(s);
    }

    public void delete(int studentId) {
        studentRepo.delete(studentId);
    }

    public void update(int studentId, Student s) {
        studentRepo.update(studentId, s);
    }

    public List<Student> getByMajor(String major) {
        return studentRepo.getByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
