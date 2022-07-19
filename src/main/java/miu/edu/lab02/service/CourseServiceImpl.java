package miu.edu.lab02.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.model.Course;
import miu.edu.lab02.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;
    public List<Course> findAll() {
        return repository.findAll();
    }

    public Course save(Course course) {
        return repository.save(course);
    }

    public Course update(Integer id, Course course) {
        Optional<Course> updating = repository.findById(id);
        if (updating.isPresent()) {
           
            return repository.save(updating.get());
        }
        throw new NoSuchElementException("Not found");
    }

    public Course findOne(Integer id) {
        Optional<Course> found = repository.findById(id);
        if (found.isPresent())
            return found.get();
        throw new NoSuchElementException("Not found");
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
