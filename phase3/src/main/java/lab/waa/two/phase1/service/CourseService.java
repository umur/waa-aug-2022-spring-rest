package lab.waa.two.phase1.service;

import lab.waa.two.phase1.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
  void save(CourseDto courseDto);

  void delete(Long id);

  void update(Long id, CourseDto courseDto);

  List<CourseDto> getAll();

  CourseDto getById(Long id);
}
