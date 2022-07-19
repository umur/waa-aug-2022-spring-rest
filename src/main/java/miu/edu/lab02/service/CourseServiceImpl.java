package miu.edu.lab02.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.model.Course;
import miu.edu.lab02.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        course.setId(id);
        return repository.save(course);
    }

    public Optional<Course> findOne(Integer id) {
        return repository.findById(id);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
