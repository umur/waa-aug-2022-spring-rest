package david.edu.min.Lab2.repository;

import david.edu.min.Lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();

    public List<Course> getAll() {
        return courses;
    }

    public void save(Course c) {
        Course course = courses.stream().filter(e -> e.getId() == c.getId()).findFirst().orElse(null);
        if (course == null)
            courses.add(c);
    }

    public void deleteById(int courseId)
    {
        Course course=  courses.stream().filter(e->e.getId()==courseId).findFirst().orElse(null);
        courses.remove(course);
    }

    public void update(int courseId,Course c)
    {
        Course course=  courses.stream().filter(e->e.getId()==courseId).findFirst().orElse(null);
        if(course!=null)
            courses.remove(course);
        save(c);
    }

    public Course getById(int courseId)
    {
        Course course=  courses.stream().filter(e->e.getId()==courseId).findFirst().orElse(null);
        return course;
    }
}
