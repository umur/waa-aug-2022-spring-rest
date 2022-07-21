package com.example.lab2waa.phase3.Service;

import com.example.lab2waa.phase3.Model.Course;
import com.example.lab2waa.phase3.Model.Student;
import com.example.lab2waa.phase3.Repository.StudentRepository;
import com.example.lab2waa.phase3.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<StudentDto> findAll() {
        var students = studentRepository.findAll();
        var result = new ArrayList<StudentDto>();

        for(Student student: students){
            var studentDto = toDto(student);
            result.add(studentDto);
        }
        return result;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var studentsWithMajor =  studentRepository.getStudentsByMajor(major);
        var result = new ArrayList<StudentDto>();

        for(Student student: studentsWithMajor){
            var studentDto = toDto(student);
            result.add(studentDto);
        }
        return result;
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }

    @Override
    public Student addStudent(StudentDto studentDto) {
        return studentRepository.addStudent(dtoToEntity(studentDto));
    }


    @Override
    public Student updateStudent(StudentDto studentDto) {
//        return studentRepository.updateStudent(studentDto.dtoToEntity());
        return  mapper.map(studentDto, Student.class);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }


    //MAPPER methods
    private StudentDto toDto(Student student){
        StudentDto studentDto = mapper.map(student, StudentDto.class);
        return studentDto;
    }

    private Student dtoToEntity(StudentDto studentDto){
        Student student = mapper.map(studentDto, Student.class);
        return student;
    }
}
