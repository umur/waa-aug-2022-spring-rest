package edu.miu.restphaseI.service.impl;

import edu.miu.restphaseI.entity.Course;
import edu.miu.restphaseI.entity.Student;
import edu.miu.restphaseI.repository.StudentRepo;
import edu.miu.restphaseI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepo.update(student);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public Student getById(int id) {
        return studentRepo.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

}
