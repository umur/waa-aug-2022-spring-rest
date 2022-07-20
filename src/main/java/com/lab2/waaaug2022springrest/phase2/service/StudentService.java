package com.lab2.waaaug2022springrest.phase2.service;

import com.lab2.waaaug2022springrest.phase2.entity.Course;
import com.lab2.waaaug2022springrest.phase2.entity.Student;
import com.lab2.waaaug2022springrest.phase2.repository.StudentRepository;
import com.lab2.waaaug2022springrest.phase2.dto.StudentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(StudentDto studentDto) {
        return studentRepository.createOne(studentDto.toEntity());
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findOneById(studentId);
    }

    public List<StudentDto> getAllStudents() {

        var students = studentRepository.findAll();
        var result = new ArrayList<StudentDto>();
        StudentDto dto = new StudentDto();
        for(Student student: students) {
            result.add(dto.toDto(student));
        }
        return result;
    }

    public Student updateStudent(int studentId, StudentDto studentDto) throws IllegalStateException {
        return studentRepository.updateOne(studentId, studentDto.toEntity());
    }

    public void deleteStudent(int studentId) throws IllegalStateException {
        studentRepository.deleteOne(studentId);
    }

    public List<StudentDto> getStudentsByMajor(String major) {
        var studentsByMajor =  studentRepository.getStudentsByMajor(major);
        var result = new ArrayList<StudentDto>();
        StudentDto dto = new StudentDto();
        for(Student student: studentsByMajor) {
            result.add(dto.toDto(student));
        }
        return result;
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
}
