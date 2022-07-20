package com.miu.lab2.dto;

import java.util.List;

import com.miu.lab2.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author laithnassar
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	private String firstName;
	private String lastName;
	private String email;
	private String major;
	private List<Course> courses;

}
