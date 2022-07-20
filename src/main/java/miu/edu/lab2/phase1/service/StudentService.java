package miu.edu.lab2.phase1.service;

import miu.edu.lab2.phase1.entity.Course;
import miu.edu.lab2.phase1.entity.Student;
import miu.edu.lab2.phase1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
    public List<Student> getStudentsByMajor(String major){
        return studentRepository.findByMajor(major);
    }
    public List<Course> getCoursesByStudentId(int studentId){
        Student student = studentRepository.findById(studentId);
        return  student.getCoursesTaken();
    }
    public Student findStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public Student updateStudent(Student student) throws Exception {
        return studentRepository.update(student);
    }

    public Student deleteStudentById(int studentId) throws Exception {
        return studentRepository.delete(studentId);
    }
}
