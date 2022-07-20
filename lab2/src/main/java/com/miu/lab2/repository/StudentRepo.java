/**
 * 
 */
package com.miu.lab2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.miu.lab2.entity.Course;
import com.miu.lab2.entity.Student;

/**
 * @author laithnassar
 *
 */
@Repository
public class StudentRepo {

	private static List<Student> students = new ArrayList<>();

	public List<Student> findAll() {
		return students;
	}

	public void save(Student student) {
		students.add(student);
	}

	public Student delete(Student student) {
		students = students.stream().filter(s -> s.getId() != student.getId()).collect(Collectors.toList());
		return student;

	}

	public Student update(Student student) {
		students = students.stream().filter(s -> s.getId() != student.getId()).collect(Collectors.toList());
		students.add(student);
		return student;
	}

	public List<Student> getStudentsByMajor(String major) {
		return students.stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList());
	}

	public List<Course> getCoursesByStudentId(int studentId) {
		return students.stream().filter(s -> s.getId() == studentId).findAny()
				.orElseGet(() -> new Student(0, null, null, null, null, new ArrayList<Course>())).getCourses();
	}

}
