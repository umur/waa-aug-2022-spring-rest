package miu.edu.lab02.service;

import miu.edu.lab02.model.Course;
import miu.edu.lab02.model.Student;

import java.util.List;

interface StudentService {
    List<Student> findAll();

    Student save(Student student);

    Student update(Integer id, Student student);

    Student findOne(Integer id);

    void delete(Integer id);


    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(Integer id);
}
