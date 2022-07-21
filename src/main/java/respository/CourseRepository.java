package respository;

import domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();
    public CourseRepository (){
        Course c1 = new Course(123, "WAA", "cs545", false);
        Course c2 = new Course(234, "wap", "ccs435", false);
        courses.add(c1);
        courses.add(c2);
    }
    public List<Course> findAll(){
        return courses;
    }
    public void create(Course c){
        courses.add(c);
    }

    public void deleteById(int id) {
        courses.remove(id-1);
    }

    public void updateById(Course newCourse, int id) {
        Course oldCourse = findAll()
                .stream()
                .filter(c-> c.getId() == id)
                .findFirst().get();
        oldCourse.setCode(newCourse.getCode());
        oldCourse.setName(newCourse.getName());
    }
}
