package lab2.phase2.service;

import lab2.phase2.domain.Course;
import lab2.phase2.dto.CourseDTO;
import lab2.phase2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService {
    private final CourseRepository repo;

    @Autowired
    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    @Override
    public Boolean create(CourseDTO course) {
        return repo.create(new Course(course.getId(),course.getName(),course.getCode()));
    }

    @Override
    public List<CourseDTO> read() {
        var data = repo.read();
        var result = new ArrayList<CourseDTO>();
        data.forEach(e->result.add(new CourseDTO(e.getId(),e.getName(),e.getCode())));
        return result;
    }

    @Override
    public Boolean update(int id, CourseDTO course) {
        return repo.update(id, new Course(course.getId(),course.getName(),course.getCode()));
    }

    @Override
    public Boolean delete(int id) {
        return repo.delete(id);
    }
}
