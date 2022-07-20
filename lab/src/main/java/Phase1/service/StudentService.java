package Phase1.service;

import Phase1.domain.Course;
import Phase1.domain.Student;
import Phase1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
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
        studentRepository.createStudent(student);
        return student;
    }

    public Student updateStudent(Student student) throws Exception {
        return studentRepository.updateOne(student);
    }

    public Student removeStudentById(int studentId) throws Exception {
        return studentRepository.removeById(studentId);
    }
}
