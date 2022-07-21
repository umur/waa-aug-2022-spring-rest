package bekmax.phase3.service;

import bekmax.phase3.dto.CourseDto;
import bekmax.phase3.dto.StudentDto;
import bekmax.phase3.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentDto> fetchAll() {
        return studentRepository.getStudents();
    }

    public StudentDto save(StudentDto sd) {
        return studentRepository.save(sd);
    }

    public void delete(long id) {
        studentRepository.delete(id);
    }

    public void update(long id, StudentDto sd) {
        studentRepository.update(id, sd);
    }

    public List<StudentDto> getByMajor(String major) {
        return studentRepository.getByMajor(major);
    }

    public List<CourseDto> getCoursesByStudentId(long id) {
        return studentRepository.getCoursesByStudentId(id);
    }
}
