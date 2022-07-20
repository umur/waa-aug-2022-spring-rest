package miu.edu.lab2.services.impl;

import miu.edu.lab2.dtos.CourseDto;
import miu.edu.lab2.dtos.MinimalStudentDto;
import miu.edu.lab2.dtos.StudentDto;
import miu.edu.lab2.models.Course;
import miu.edu.lab2.models.Student;
import miu.edu.lab2.repositories.StudentRepo;
import miu.edu.lab2.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAll() {
        var students = studentRepo.getAll();
        return students.stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public void save(StudentDto studentDto) {
        var student = modelMapper.map(studentDto, Student.class);
        studentRepo.save(student);
    }

    @Override
    public void delete(StudentDto studentDto) {
        var student = modelMapper.map(studentDto, Student.class);
        studentRepo.delete(student);
    }

    @Override
    public List<MinimalStudentDto> getStudentByMajor(String major) {
        var students = studentRepo.getStudentByMajor(major);
        return  students.stream().map(student -> modelMapper.map(student, MinimalStudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        var courses = studentRepo.getCourseListByStudentId(studentId);
        return courses.stream().map(course -> modelMapper.map(course, CourseDto.class)).collect(Collectors.toList());
    }
}
