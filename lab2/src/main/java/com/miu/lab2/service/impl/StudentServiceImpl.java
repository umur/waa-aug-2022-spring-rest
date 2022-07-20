/**
 * 
 */
package com.miu.lab2.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miu.lab2.dto.CourseDto;
import com.miu.lab2.dto.StudentDto;
import com.miu.lab2.entity.Student;
import com.miu.lab2.repository.StudentRepo;
import com.miu.lab2.service.StudentService;

/**
 * @author laithnassar
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<StudentDto> findAll() {
		return studentRepo.findAll().stream().map(s -> mapper.map(s, StudentDto.class)).collect(Collectors.toList());
	}

	@Override
	public void save(StudentDto studentDto) {
		studentRepo.save(mapper.map(studentDto, Student.class));
	}

	@Override
	public StudentDto delete(StudentDto studentDto) {
		return mapper.map(studentRepo.delete(mapper.map(studentDto, Student.class)), StudentDto.class);
	}

	@Override
	public StudentDto update(StudentDto studentDto) {
		return mapper.map(studentRepo.update(mapper.map(studentDto, Student.class)), StudentDto.class);
	}

	@Override
	public List<StudentDto> getStudentsByMajor(String major) {
		return studentRepo.getStudentsByMajor(major).stream().map(s -> mapper.map(s, StudentDto.class))
				.collect(Collectors.toList());

	}

	@Override
	public List<CourseDto> getCoursesByStudentId(int studentId) {
		return studentRepo.getCoursesByStudentId(studentId).stream()
				.map(s -> mapper.map(s, CourseDto.class))
				.collect(Collectors.toList());

	}

}
