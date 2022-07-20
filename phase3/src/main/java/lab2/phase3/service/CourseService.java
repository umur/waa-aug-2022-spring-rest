package lab2.phase3.service;

import lab2.phase3.domain.Course;
import lab2.phase3.dto.CourseDTO;
import lab2.phase3.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService {
    private final CourseRepository repo;
    private final ModelMapper mapper;

    @Autowired
    public CourseService(CourseRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Boolean create(CourseDTO course) {
        return repo.create(mapper.map(course, Course.class));
    }

    @Override
    public List<CourseDTO> read() {
        var data = repo.read();
        var result = new ArrayList<CourseDTO>();
        data.forEach(e -> result.add(mapper.map(e, CourseDTO.class)));
        return result;
    }

    @Override
    public Boolean update(int id, CourseDTO course) {
        return repo.update(id, mapper.map(course, Course.class));
    }

    @Override
    public Boolean delete(int id) {
        return repo.delete(id);
    }
}
