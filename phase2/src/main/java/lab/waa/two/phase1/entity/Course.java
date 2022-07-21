package lab.waa.two.phase1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
  private Long id;
  private String name;
  private String code;
  private boolean deleted;
}
