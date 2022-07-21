package lab.waa.two.phase1.mapper;

import lab.waa.two.phase1.dto.CourseDto;
import lab.waa.two.phase1.entity.Course;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseMapper {
  private final ModelMapper modelMapper;

  public CourseDto toDTO(Course course) {
    return modelMapper.map(course, CourseDto.class);
  }

  public Course toCourse(CourseDto dto) {
    return modelMapper.map(dto, Course.class);
  }
}
