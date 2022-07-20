package com.miu.lab2.entity;

import java.util.List;

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
public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String major;
	private List<Course> courses;

}
