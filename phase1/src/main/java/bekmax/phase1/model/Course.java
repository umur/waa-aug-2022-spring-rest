package bekmax.phase1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    long id;
    String name;
    String code;
    boolean isDeleted;
}
