package edu.miu.RestDemoApplication.service;

import edu.miu.RestDemoApplication.dto.CourseDTO;
import edu.miu.RestDemoApplication.dto.StudentDTO;
import edu.miu.RestDemoApplication.entity.Student;
import edu.miu.RestDemoApplication.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    final private StudentRepo studentRepo;

    @Autowired
    final private ModelMapper modelMapper;

    @Override
    public List<StudentDTO> findAll() {
        var students = studentRepo.findAll();
        var result = new ArrayList<StudentDTO>();
        students.forEach(student -> {
            var dto = modelMapper.map(student, StudentDTO.class);
            result.add(dto);
        });
        return result;
    }

    @Override
    public StudentDTO findByID(long id) {
        var student = studentRepo.findByID(id);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        var student = modelMapper.map(studentDTO, Student.class);
        return modelMapper.map(studentRepo.addStudent(student), StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        var student = modelMapper.map(studentDTO, Student.class);
        return modelMapper.map(studentRepo.updateStudent(student), StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        var students = studentRepo.getStudentsByMajor(major);
        var result = new ArrayList<StudentDTO>();
        students.forEach(student -> {
            var dto = modelMapper.map(student, StudentDTO.class);
            result.add(dto);
        });
        return result;
    }

    @Override
    public List<CourseDTO> getCoursesByStudentID(long id) {
        var courses = studentRepo.getCoursesByStudentID(id);
        var result = new ArrayList<CourseDTO>();
        courses.forEach(course -> {
            result.add(modelMapper.map(course, CourseDTO.class));
        });
        return result;
    }

    @Override
    public void removeStudentByID(long id) {
        studentRepo.removeStudentByID(id);
    }
}
