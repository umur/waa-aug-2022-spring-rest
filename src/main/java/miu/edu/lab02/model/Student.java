package miu.edu.lab02.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    String firstName;
    String lastName;
    String email;
    String major;

    @OneToMany
    List<Course> coursesTaken;
    Double gpa;
}
