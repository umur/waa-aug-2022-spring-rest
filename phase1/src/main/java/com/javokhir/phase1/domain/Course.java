package com.javokhir.phase1.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Course {

    private UUID id;
    private String name;
    private String code;

}
