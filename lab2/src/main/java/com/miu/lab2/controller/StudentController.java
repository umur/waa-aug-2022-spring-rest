/**
 * 
 */
package com.miu.lab2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miu.lab2.dto.CourseDto;
import com.miu.lab2.dto.StudentDto;
import com.miu.lab2.service.StudentService;

/**
 * @author laithnassar
 *
 */
@RestController
@RequestMapping("/Students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<StudentDto> findAll() {
		return studentService.findAll();
	}

	@PostMapping
	public void save(@RequestBody StudentDto studentDto) {
		studentService.save(studentDto);
	}

	@DeleteMapping
	public StudentDto delete(@RequestBody StudentDto studentDto) {
		return studentService.delete(studentDto);
	}

	@PutMapping
	public StudentDto update(@RequestBody StudentDto studentDto) {
		return studentService.update(studentDto);
	}

	@GetMapping("/{major}")
	public List<StudentDto> getStudentsByMajor(@PathVariable String major) {
		return studentService.getStudentsByMajor(major);
	}

	@GetMapping("/{studentId}/courses")
	public List<CourseDto> getCoursesByStudentId(@PathVariable int studentId) {
		return studentService.getCoursesByStudentId(studentId);
	}
}
