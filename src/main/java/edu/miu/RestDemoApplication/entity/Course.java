package edu.miu.RestDemoApplication.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private long id;
    private String name;
    private String code;

    private boolean deleted;
}
