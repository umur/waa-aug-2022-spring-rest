package miu.edu.test.repo;

import miu.edu.test.dto.StudentCreateDto;
import miu.edu.test.entity.Course;
import miu.edu.test.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    public static List<Course> courses= new ArrayList<Course>();

    static {
        Course c1= new Course(Course.GetNextId(), "WAP","CSE407",false);
        Course c2= new Course(Course.GetNextId(), "WAA","CSE500",false);
        Course c3= new Course(Course.GetNextId(), "MPP","CSE404",false);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }

    public Course save(Course s) {
        var notExists = courses
                .stream()
                .noneMatch(l -> l.getId() == s.getId());

        if (notExists) {
            courses.add(s);
            return s;
        }else {
            return null;
        }
    }

    public Course delete(int id) {
        // set deleted to true
        var student = courses
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
        if(student!= null){
            student.setDeleted(true);
            return student;
        }

        return null;
    }

    public Course getById(int id) {
        return courses
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }

    public List<Course> getAll(){
        return  courses.stream()
                .filter(l->!l.isDeleted())
                .collect(Collectors.toList());
    }

    public List<Course> getByIds(List<Integer> cIds){
        return  courses.stream()
                .filter(l->!l.isDeleted() && cIds.contains(l.getId()))
                .collect(Collectors.toList());
    }
    public Course update(int id, Course cr){
        var courseDb = courses.stream().filter(c -> !c.isDeleted() && c.getId() == id).findFirst().orElse(null);
        if(courseDb == null) {
            return null;
        }

        return  courseDb;
    }
}
