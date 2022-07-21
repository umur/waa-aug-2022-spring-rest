package com.example.lab2waa.phase2.Service;

import com.example.lab2waa.phase2.Model.Course;
import com.example.lab2waa.phase2.Model.Student;
import com.example.lab2waa.phase2.Repository.StudentRepository;
import com.example.lab2waa.phase2.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;


    @Override
    public List<StudentDto> findAll() {
        var students = studentRepository.findAll();
        StudentDto studentDto = new StudentDto();
        var result = studentDto.toDto(students);
        return result;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var studentsWithMajor =  studentRepository.getStudentsByMajor(major);
        StudentDto studentDto = new StudentDto();
        var result = studentDto.toDto(studentsWithMajor);
        return result;
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }

    @Override
    public Student addStudent(StudentDto studentDto) {
        return studentRepository.addStudent(studentDto.dtoToEntity());
    }


    @Override
    public Student updateStudent(StudentDto studentDto) {
        return studentRepository.updateStudent(studentDto.dtoToEntity());
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }
}
