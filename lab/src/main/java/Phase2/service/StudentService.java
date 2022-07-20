package Phase2.service;

import Phase2.domain.Course;
import Phase2.domain.Student;
import Phase2.dto.StudentDto;
import Phase2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;

    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }
    public List<Student> getStudentsByMajor(String major){
        return studentRepo.findByMajor(major);
    }
    public List<Course> getCoursesByStudentId(int studentId){
        Student student = studentRepo.findById(studentId);
        return  student.getCoursesTaken();
    }
    public Student findStudentById(int id) {
        return studentRepo.findById(id);
    }

    public Student createStudent(StudentDto studentDto) {
        Student student = studentDto.toStudent();
        studentRepo.createStudent(student);
        return student;
    }

    public Student updateStudent(StudentDto studentDto) throws Exception {
        Student student = studentDto.toStudent();
        return studentRepo.updateOne(student);
    }

    public Student removeStudentById(int studentId) throws Exception {
        return studentRepo.removeById(studentId);
    }
}
