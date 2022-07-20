package com.miu.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDto {

    private Long id;

    private String name;

    private String code;
}
