package bekmax.phase2.service;

import bekmax.phase2.dto.CourseDto;
import bekmax.phase2.dto.StudentDto;
import bekmax.phase2.repository.StudentRepository;
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

    public List<StudentDto> fetchAll() {
        return studentRepository.getStudents();
    }

    public StudentDto save(StudentDto studentDto) {
        return studentRepository.save(studentDto);
    }

    public void delete(long id) {
        studentRepository.delete(id);
    }

    public void update(long id, StudentDto studentDto) {
        studentRepository.update(id, studentDto);
    }

    public List<StudentDto> getByMajor(String major){
        return studentRepository.getByMajor(major);
    }

    public List<CourseDto> getCoursesByStudentId(long id){
        return studentRepository.getCoursesByStudentId(id);
    }
}
