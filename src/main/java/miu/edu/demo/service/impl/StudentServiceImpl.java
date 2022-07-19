package miu.edu.demo.service.impl;

import miu.edu.demo.entity.Course;
import miu.edu.demo.entity.Student;
import miu.edu.demo.repository.StudentRepo;
import miu.edu.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.filterStudents(student -> student.getMajor().equals(major));
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("No such student with id: " + studentId));
        return student.getCoursesTaken();
    }

}
