package bekmax.phase1.service;

import bekmax.phase1.model.Course;
import bekmax.phase1.model.Student;
import bekmax.phase1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> fetchAll() {
        return studentRepository.getStudents();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void delete(long id) {
        studentRepository.delete(id);
    }

    public void update(long id, Student student) {
        studentRepository.update(id, student);
    }

    public List<Student> getByMajor(String major){
        return studentRepository.getByMajor(major);
    }

    public List<Course> getCoursesByStudentId(long id){
        return studentRepository.getCoursesByStudentId(id);
    }
}
