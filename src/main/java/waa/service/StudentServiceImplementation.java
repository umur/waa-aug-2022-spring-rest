package waa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.domain.Course;
import waa.domain.Student;
import waa.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        studentRepository.create(student);
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public List<Student> findStudentByMajor(String major) {
        return studentRepository.findByMajor(major);
    }

    @Override
    public Student updateStudent(Student student) throws Exception {
        return studentRepository.updateStudent(student);
    }

    @Override
    public Student removeStudentById(Integer studnetId) throws Exception {
        return studentRepository.removeById(studnetId);
    }

    @Override
    public List<Course> findCoursesByStudentId(Integer studnetId) {
        return studentRepository.findById(studnetId).getCoursesTaken();
    }
}
