package bekmax.phase3.service;

import bekmax.phase3.dto.CourseDto;
import bekmax.phase3.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseDto> fetchAll(){
        return courseRepository.getCourses();
    }

    public CourseDto save(CourseDto cd){
        return courseRepository.save(cd);
    }

    public void delete(long id){
        courseRepository.delete(id);
    }

    public void update(long id, CourseDto cd){
        courseRepository.update(id, cd);
    }
}
