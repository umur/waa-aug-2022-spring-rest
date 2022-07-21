package miu.edu.test.service.impl;

import miu.edu.test.dto.CourseDto;
import miu.edu.test.dto.StudentCreateDto;
import miu.edu.test.dto.StudentDto;
import miu.edu.test.entity.Course;
import miu.edu.test.entity.Student;
import miu.edu.test.repo.CourseRepo;
import miu.edu.test.repo.StudentRepo;
import miu.edu.test.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAll() {

        var result = new ArrayList< StudentDto >();
        var studentEntity = studentRepo.getAll();

        studentEntity.forEach(s->{
            result.add(modelMapper.map(s,StudentDto.class));
        });
        return result;
    }

    @Override
    public StudentDto getStudent(int id) {
        var stu = studentRepo.getById(id);
        return modelMapper.map(stu, StudentDto.class);
    }

    @Override
    public StudentDto create(StudentCreateDto student) {
        var stu = modelMapper.map(student, Student.class);
        stu.setCoursesTaken(new ArrayList<Course>());
        stu.setId(Student.GetNextId());
        var courseIds = student.getCoursesTaken();
        var selectedCourses = courseRepo.getByIds(courseIds);
        if(!selectedCourses.isEmpty()){
            stu.setCoursesTaken(selectedCourses);
        }

        var createdStudent = studentRepo.save(stu);

        return modelMapper.map(createdStudent,StudentDto.class);

    }

    @Override
    public StudentDto delete(int id) {
        var stu = studentRepo.delete(id);
        return modelMapper.map(stu, StudentDto.class);
    }

    @Override
    public StudentDto update(int id, StudentCreateDto stu) {
        var courses = courseRepo.getByIds(stu.getCoursesTaken());
        var studentEntity = studentRepo.Update(id, stu,courses);
        if(studentEntity== null)
            return null;
        return modelMapper.map(studentEntity,StudentDto.class);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {

        var result = new ArrayList< StudentDto >();
        var studentEntity =studentRepo.getByMajor(major);

        if(studentEntity== null)
            return new ArrayList<>();
        studentEntity.forEach(s->{
            result.add(modelMapper.map(s,StudentDto.class));
        });
        return result;
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        var stu = studentRepo.getById(studentId);
        if(stu== null)
            return new ArrayList<>();
        List<CourseDto> result = new ArrayList<>();

        stu.getCoursesTaken().forEach(c->result.add(modelMapper.map(c, CourseDto.class)));
        return result;
    }


}
