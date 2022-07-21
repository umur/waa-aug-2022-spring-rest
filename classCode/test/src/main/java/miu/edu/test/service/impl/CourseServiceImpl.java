package miu.edu.test.service.impl;

import miu.edu.test.dto.CourseDto;
import miu.edu.test.entity.Course;
import miu.edu.test.repo.CourseRepo;
import miu.edu.test.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CourseDto> getAll() {

        var result = new ArrayList< CourseDto >();
        var entity = courseRepo.getAll();

        entity.forEach(s->{
            result.add(modelMapper.map(s,CourseDto.class));
        });
        return result;
    }

    @Override
    public CourseDto getById(int id) {
        var cr = courseRepo.getById(id);
        if(cr==null)
            return null;
        return modelMapper.map(cr, CourseDto.class);
    }

    @Override
    public CourseDto create(CourseDto course) {
        var ct = modelMapper.map(course, Course.class);
        ct.setId(Course.GetNextId());

        var entity = courseRepo.save(ct);

        return modelMapper.map(entity,CourseDto.class);

    }

    @Override
    public CourseDto delete(int id) {
        var stu = courseRepo.delete(id);
        return modelMapper.map(stu, CourseDto.class);
    }

    @Override
    public CourseDto update(int id, CourseDto stu) {
        var course = courseRepo.getById(id);
        if(course== null)
            return null;
        course.setName(stu.getName());
        course.setCode(stu.getCode());

        return modelMapper.map(course,CourseDto.class);
    }
}
