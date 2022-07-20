/**
 * 
 */
package com.miu.lab2.service;

import java.util.List;

import com.miu.lab2.dto.CourseDto;
import com.miu.lab2.dto.StudentDto;

/**
 * @author laithnassar
 *
 */
public interface StudentService {
	
	public List<StudentDto> findAll() ;

	public void save(StudentDto studentDto) ;

	public StudentDto delete(StudentDto studentDto);

	public StudentDto update(StudentDto studentDto) ;
	

	public List<StudentDto> getStudentsByMajor(String major) ;

	public List<CourseDto> getCoursesByStudentId(int studentId);

}
