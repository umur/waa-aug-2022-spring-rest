package com.example.lab2waa.phase2.Repository;


import com.example.lab2waa.phase2.Model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private static List<Course> courses = new ArrayList<>();

    public CourseRepository(){
        Course course1 = new Course(123,"ClCmp", "CS555");
        Course course2 = new Course(456,"WAP", "CS425");
        Course course3 = new Course(789,"SE", "CS475");
        Course course4 = new Course(012,"WAA", "CS575");

        courses.addAll(List.of(course1,course2,course3,course4));
    }

    public Course findById(int id){
        return courses.get(id + 1);
    }

    public List<Course> findAll(){
        return courses;
    }

}
