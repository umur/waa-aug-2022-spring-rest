package david.edu.min.Lab2.service.impl;


import david.edu.min.Lab2.entity.Course;
import david.edu.min.Lab2.entity.Student;
import david.edu.min.Lab2.repository.StudentRepo;
import david.edu.min.Lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo productRepo;
    @Override
    public List<Student> getAll() {
        var entityList=  productRepo.getAll();
        return entityList;
    }

    @Override
    public void save(Student s) {
        productRepo.save(s);
    }

    @Override
    public void deleteById(int studentId) {
        productRepo.deleteById(studentId);
    }

    @Override
    public void update(int studentId, Student s) {
        productRepo.update(studentId,s);
    }

    @Override
    public Student getById(int studentId) {
        var entity=  productRepo.getById(studentId);
        return entity;
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {

        var entityList=  productRepo.getStudentsByMajor(major);
        return entityList;
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        var entityList=  productRepo.getCoursesByStudentId(studentId);
        return entityList;
    }
}
