package miu.edu.lab2.repositories;

import miu.edu.lab2.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    public static List<Course> courses =  new ArrayList<>();

    public static void main(String[] args) {
        courses.add(new Course(1, "MPP", "CSMPP"));
        courses.add(new Course(2, "WAP", "CSWAP"));
        courses.add(new Course(3, "WAA", "CSWAA"));
        courses.add(new Course(4, "EA", "CSEA"));
    }
    public List<Course> getAll(){
        return courses;
    }
    public void save(Course course){
        courses.add(course);
    }

    public void delete(Course course){
        courses.remove(course);
    }
}
