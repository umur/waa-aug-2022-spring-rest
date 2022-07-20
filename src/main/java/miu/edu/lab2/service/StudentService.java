package miu.edu.lab2.service;

import miu.edu.lab2.dto.StudentDTO;
import miu.edu.lab2.entity.Course;
import miu.edu.lab2.entity.Student;
import miu.edu.lab2.repository.StudentRepository;
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

    public Student createStudent(StudentDTO studentDTO) {
        Student student = studentDTO.toStudent();
        studentRepository.save(student);
        return student;
    }

    public Student updateStudent(StudentDTO studentDTO) throws Exception {
        Student student = studentDTO.toStudent();
        return studentRepository.update(student);
    }

    public Student deleteStudentById(int studentId) throws Exception {
        return studentRepository.delete(studentId);
    }
}
