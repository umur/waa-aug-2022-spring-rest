package com.waa.lab2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Course {
    Long id;
    String name;
    String code;
    boolean deleted;
}
