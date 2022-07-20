package miu.edu.lab02.dto;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CourseMapper {
    private final ModelMapper modelMapper;

    public CourseDTO convertToDto(Course course) {
        return modelMapper.map(course, CourseDTO.class);
    }

    public Course convertToEntity(CourseDTO dto) throws ParseException {
        return modelMapper.map(dto, Course.class);
    }
}
