package miu.edu.lab02.dto;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentMapper {
    private final ModelMapper modelMapper;

    public StudentDTO convertToDto(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    public Student convertToEntity(StudentDTO dto) throws ParseException {
        return modelMapper.map(dto, Student.class);
    }
}
