package waa.phase3.repository;

import org.springframework.stereotype.Repository;
import waa.phase3.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static final List<Course> courses = new ArrayList<>();

    {
        courses.add(new Course(1, "WAA", 511, false));
        courses.add(new Course(2, "WAP", 471, false));
        courses.add(new Course(3, "ALG", 551, false));
    }

    public List<Course> findAll() {
        return courses.stream().filter(course -> !course.isDeleted()).collect(Collectors.toList());
    }

    public void deleteById(int id) {
        courses.stream().filter(course -> course.getId() == id).forEach(course -> course.setDeleted(true));
    }

    public void save(Course course) {
        courses.add(course);
    }

    public void update(int id, Course course) {
        if(id != course.getId()) return;
        Course needCheck = courses.stream().filter(cou -> cou.getId() == id).collect(Collectors.toList()).get(0);
        if (needCheck != null) {
            courses.remove(needCheck);
        }
        save(course);
    }

    public Course findById(int id) {
        return courses.stream().filter(course -> !course.isDeleted() && course.getId() == id).collect(Collectors.toList()).get(0);
    }
}
