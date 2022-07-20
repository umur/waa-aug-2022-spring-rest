package miu.edu.lab02.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.dto.CourseDTO;
import miu.edu.lab02.dto.CourseMapper;
import miu.edu.lab02.dto.StudentDTO;
import miu.edu.lab02.dto.StudentMapper;
import miu.edu.lab02.model.Course;
import miu.edu.lab02.model.Student;
import miu.edu.lab02.repository.CourseRepository;
import miu.edu.lab02.repository.StudentRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final CourseRepository courseRepository;

    private final StudentMapper studentMapper;

    public List<StudentDTO> findAll() {
        return repository.findAll().stream()
                .map(studentMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public StudentDTO save(StudentDTO student) {
        return studentMapper.convertToDto(repository.save(studentMapper.convertToEntity(student)));
    }

    public StudentDTO update(Integer id, StudentDTO student) {
        student.setId(id);
        return studentMapper.convertToDto(repository.save(studentMapper.convertToEntity(student)));
    }

    public Optional<StudentDTO> findOne(Integer id) {
        return repository.findById(id).map(studentMapper::convertToDto);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public StudentDTO addCourse(Integer studentId, String courseCode) {
        Optional<Student> adding = repository.findById(studentId);
        return adding.map(student -> {
            Optional<Course> course = courseRepository.findByCode(courseCode);
            return course.map(c -> {
                try {
                    student.addCourse(c);
                    return studentMapper.convertToDto(repository.save(student));
                } catch (DataIntegrityViolationException e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already existed");
                }

            }).orElseGet(() -> null);
        }).orElseGet(() -> null);
    }

    public StudentDTO removeCourse(Integer studentId, String courseCode) {
        Optional<Student> removing = repository.findById(studentId);
        return removing.map(student -> {
            Optional<Course> course = courseRepository.findByCode(courseCode);
            return course.map(c -> {
                student.removeCourse(c);
                return studentMapper.convertToDto(repository.save(student));
            }).orElseGet(() -> null);
        }).orElseGet(() -> null);
    }

    public List<StudentDTO> getStudentsByMajor(String major) {
        return this.repository.findByMajor(major)
                .stream()
                .map(studentMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CourseDTO> getCoursesByStudentId(Integer id) {
        Optional<StudentDTO> found = this.findOne(id);
        if (found.isPresent())
            return found.get().getCoursesTaken();
        return new ArrayList<>();
    }

}
