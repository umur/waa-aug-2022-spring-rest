package miu.edu.lab02.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.model.Course;
import miu.edu.lab02.model.Student;
import miu.edu.lab02.repository.CourseRepository;
import miu.edu.lab02.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final CourseRepository courseRepository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public Student update(Integer id, Student student) {
        student.setId(id);
        return repository.save(student);
    }

    public Optional<Student> findOne(Integer id) {
        return repository.findById(id);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Student addCourse(Integer studentId, String courseCode) {
        Optional<Student> adding = repository.findById(studentId);
        return adding.map(student -> {
            Optional<Course> course = courseRepository.findByCode(courseCode);
            return course.map(c -> {
                student.addCourse(c);
                return repository.save(student);
            }).orElseGet(() -> null);
        }).orElseGet(() -> null);
    }

    public Student removeCourse(Integer studentId, String courseCode) {
        Optional<Student> removing = repository.findById(studentId);
        return removing.map(student -> {
            Optional<Course> course = courseRepository.findByCode(courseCode);
            return course.map(c -> {
                student.removeCourse(c);
                return repository.save(student);
            }).orElseGet(() -> null);
        }).orElseGet(() -> null);
    }

    public List<Student> getStudentsByMajor(String major) {
        return this.repository.findByMajor(major);
    }

    public List<Course> getCoursesByStudentId(Integer id) {
        Optional<Student> found = this.findOne(id);
        if (found.isPresent())
            return found.get().getCoursesTaken();
        return new ArrayList<>();
    }

}
