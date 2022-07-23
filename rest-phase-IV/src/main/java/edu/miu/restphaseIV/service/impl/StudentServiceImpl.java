package edu.miu.restphaseIV.service.impl;

import edu.miu.restphaseIV.dto.CourseDto;
import edu.miu.restphaseIV.dto.StudentDto;
import edu.miu.restphaseIV.entity.Student;
import edu.miu.restphaseIV.repository.CourseRepo;
import edu.miu.restphaseIV.repository.StudentRepo;
import edu.miu.restphaseIV.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student savedStudent = studentRepo.save(modelMapper.map(studentDto, Student.class));

        return savedStudent != null ? modelMapper.map(savedStudent, StudentDto.class) : null;
    }

    @Override
    public void update(StudentDto studentDto) {
        studentRepo.update(modelMapper.map(studentDto, Student.class));
    }

    @Override
    public StudentDto delete(int id) {
        Student deletedStudent = studentRepo.delete(id);
        return (deletedStudent != null) ? modelMapper.map(deletedStudent, StudentDto.class) : null;
    }

    @Override
    public StudentDto getById(int id) {
        var student = studentRepo.getById(id);
        return (student != null) ? modelMapper.map(student, StudentDto.class) : null;
    }

    @Override
    public List<StudentDto> getAll() {
        var students = studentRepo.getAll();
        return students.stream().map(s -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        var courses = studentRepo.getCoursesByStudentId(studentId);
        return courses.stream().map(c -> modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> addCourseToStudent(int id, int courseId) {
        var course = courseRepo.getById(courseId);
        if(course != null) {
            var courses = studentRepo.addCourseToStudent(id, course);;
            if(courses != null)
                return courses.stream().map(c -> modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<CourseDto> deleteCourseFromStudent(int id, int courseId) {
        var courses = studentRepo.deleteCourseFromStudent(id, courseId);
        return courses.stream().map(c -> modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var students = studentRepo.getStudentsByMajor(major);
        return students.stream().map(s -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }


}
