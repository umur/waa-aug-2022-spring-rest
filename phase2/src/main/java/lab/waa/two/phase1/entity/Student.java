package lab.waa.two.phase1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String major;
  private Double gpa;
  private List<Course> coursesTaken;
  private boolean deleted;
}
