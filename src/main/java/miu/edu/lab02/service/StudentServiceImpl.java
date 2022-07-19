package miu.edu.lab02.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.model.Course;
import miu.edu.lab02.model.Student;
import miu.edu.lab02.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public Student update(Integer id, Student student) {
        Optional<Student> updating = repository.findById(id);
        if (updating.isPresent()) {

            return repository.save(updating.get());
        }
        throw new NoSuchElementException("Not found");
    }

    public Student findOne(Integer id) {
        Optional<Student> found = repository.findById(id);
        if (found.isPresent())
            return found.get();
        throw new NoSuchElementException("Not found");
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return this.repository.findByMajor(major);
    }

    public List<Course> getCoursesByStudentId(Integer id) {
        return this.findOne(id).getCoursesTaken();
    }

}
