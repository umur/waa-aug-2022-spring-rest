package waa.phase1.repository;

import org.springframework.stereotype.Repository;
import waa.phase1.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();
    {
        courses.add(new Course(1,"WAA", 511,false));
        courses.add(new Course(2,"WAP", 471,false));
        courses.add(new Course(3,"ALG", 551,false));
    }

    public List<Course> findAll() {
        return courses;
    }

    public void deleteById(int id) {
        courses = courses.stream().filter(course -> course.getId() != id).collect(Collectors.toList());
    }

    public void save(Course course) {
        courses.add(course);
    }

    public void update(int id, Course course) {
        Course needCheck = courses.stream().filter(cou -> cou.getId() != id).collect(Collectors.toList()).get(0);
        if (needCheck != null) {
            courses.remove(needCheck);
        }
        save(course);
        courses.add(course);
    }
}
