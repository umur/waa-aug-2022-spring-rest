package edu.miu.restphaseIII.service.impl;

import edu.miu.restphaseIII.dto.CourseDto;
import edu.miu.restphaseIII.dto.StudentDto;
import edu.miu.restphaseIII.repository.StudentRepo;
import edu.miu.restphaseIII.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public void save(StudentDto studentDto) {
        studentRepo.save(studentDto.convertToStudent());
    }

    @Override
    public void update(StudentDto studentDto) {
        studentRepo.update(studentDto.convertToStudent());
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public StudentDto getById(int id) {
        return studentRepo.getById(id).convertToDto();
    }

    @Override
    public List<StudentDto> getAll() {
        var students = studentRepo.getAll();
        return students.stream().map(s -> s.convertToDto()).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        var courses = studentRepo.getCoursesByStudentId(studentId);
        return courses.stream().map(c -> c.convertToDto()).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var students = studentRepo.getStudentsByMajor(major);
        return students.stream().map(s -> s.convertToDto()).collect(Collectors.toList());
    }


}
