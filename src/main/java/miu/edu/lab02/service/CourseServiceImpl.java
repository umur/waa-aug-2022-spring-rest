package miu.edu.lab02.service;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.dto.CourseDTO;
import miu.edu.lab02.dto.CourseMapper;
import miu.edu.lab02.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    private final CourseMapper mapper;
    public List<CourseDTO> findAll() {
        return repository.findAll()
                .stream().map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    public CourseDTO save(CourseDTO course) {
        return mapper.convertToDto(repository.save(mapper.convertToEntity(course)));
    }

    public CourseDTO update(Integer id, CourseDTO course) {
        course.setId(id);
        return mapper.convertToDto(repository.save(mapper.convertToEntity(course)));
    }

    public Optional<CourseDTO> findOne(Integer id) {
        return repository.findById(id).map(mapper::convertToDto);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
