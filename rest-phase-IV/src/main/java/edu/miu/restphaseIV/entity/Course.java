package edu.miu.restphaseIV.entity;

import lombok.Data;

@Data
public class Course {
    private int id;
    private String name;
    private String code;

    private boolean deleted;

}
