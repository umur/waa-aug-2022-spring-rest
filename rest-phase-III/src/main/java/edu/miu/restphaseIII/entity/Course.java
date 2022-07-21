package edu.miu.restphaseIII.entity;

import lombok.Data;

@Data
public class Course {
    private int id;
    private String name;
    private String code;

    private boolean deleted;

}
