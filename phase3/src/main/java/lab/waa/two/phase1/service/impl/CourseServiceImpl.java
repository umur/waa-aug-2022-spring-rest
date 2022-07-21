package lab.waa.two.phase1.service.impl;

import lab.waa.two.phase1.dto.CourseDto;
import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.mapper.CourseMapper;
import lab.waa.two.phase1.repository.CourseRepo;
import lab.waa.two.phase1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
  private final CourseRepo courseRepo;
  private final CourseMapper courseMapper;

  @Override
  public void save(CourseDto courseDto) {
    courseRepo.save(courseMapper.toCourse(courseDto));
  }

  @Override
  public void delete(Long id) {
    courseRepo.delete(id);
  }

  @Override
  public void update(Long id, CourseDto courseDto) {
    courseRepo.update(id, courseMapper.toCourse(courseDto));
  }

  @Override
  public List<CourseDto> getAll() {
    return courseRepo.getAll()
      .stream()
      .map(courseMapper::toDTO)
      .collect(Collectors.toList());
  }

  @Override
  public CourseDto getById(Long id) {
    return courseMapper.toDTO(courseRepo.getById(id));
  }
}
