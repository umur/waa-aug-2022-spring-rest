package com.waa.lab2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    Long id;
    String name;
    String code;
    boolean deleted;
}
