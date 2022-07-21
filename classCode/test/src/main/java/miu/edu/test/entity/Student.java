package miu.edu.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private static int autoInc=0;
    //id, firstName, lastName, email, major, and coursesTaken
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private boolean deleted;

    public static int GetNextId(){
        return ++autoInc;
    }
}
