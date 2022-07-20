package com.lab2.waaaug2022springrest.phase3.service;

import com.lab2.waaaug2022springrest.phase3.dto.StudentDto;
import com.lab2.waaaug2022springrest.phase3.entity.Course;
import com.lab2.waaaug2022springrest.phase3.entity.Student;
import com.lab2.waaaug2022springrest.phase3.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private ModelMapper modelMapper;

    public Student createStudent(StudentDto studentDto) {
        return studentRepository.createOne(toEntity(studentDto));
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findOneById(studentId);
    }

    public List<StudentDto> getAllStudents() {

        var students = studentRepository.findAll();
        var result = new ArrayList<StudentDto>();
        for(Student student: students) {
            result.add(toDto(student));
        }
        return result;
    }

    public Student updateStudent(int studentId, StudentDto studentDto) throws IllegalStateException {
        return studentRepository.updateOne(studentId, toEntity(studentDto));
    }

    public void deleteStudent(int studentId) throws IllegalStateException {
        studentRepository.deleteOne(studentId);
    }

    public List<StudentDto> getStudentsByMajor(String major) {
        var studentsByMajor =  studentRepository.getStudentsByMajor(major);
        var result = new ArrayList<StudentDto>();
        for(Student student: studentsByMajor) {
            result.add(toDto(student));
        }
        return result;
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
    private StudentDto toDto(Student student){
        StudentDto dto = modelMapper.map(student, StudentDto.class);
        return dto;
    }
    public Student toEntity(StudentDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);
        return student;
    }

}
