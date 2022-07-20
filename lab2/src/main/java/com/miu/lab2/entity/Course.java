package com.miu.lab2.entity;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author laithnassar
 *
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	private int id;
	private String name;
	private String code;

}
