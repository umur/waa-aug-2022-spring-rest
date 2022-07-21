package bekmax.phase3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    long id;
    String name;
    String code;
    boolean isDeleted;
}
