package miu.edu.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private static int autoInc =0;
    private int id;
    private String name;
    private String code;
    private boolean deleted;

    public static int GetNextId(){
        return ++autoInc;
    }
}
