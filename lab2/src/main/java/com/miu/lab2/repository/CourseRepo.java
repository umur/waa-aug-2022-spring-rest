/**
 * 
 */
package com.miu.lab2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.miu.lab2.entity.Course;

import lombok.AllArgsConstructor;

/**
 * @author laithnassar
 *
 */
@Repository
@AllArgsConstructor
public class CourseRepo {
	private static List<Course> courses = new ArrayList<>();

	public List<Course> findAll() {
		return courses;
	}

	public void save(Course course) {
		courses.add(course);
	}

	public Course delete(Course course) {
		courses = courses.stream().filter(s -> s.getId() != course.getId()).collect(Collectors.toList());
		return course;

	}

	public Course update(Course course) {
		courses = courses.stream().filter(s -> s.getId() != course.getId()).collect(Collectors.toList());
		courses.add(course);
		return course;
	}
	
	
	

}
