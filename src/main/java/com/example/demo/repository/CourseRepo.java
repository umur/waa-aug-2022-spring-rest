package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {

    public static List<Course> courses = new ArrayList<>();

    public List<Course> findAll(){
        return courses.stream().filter(l->l.isDeleted()).collect(Collectors.toList());
    }

    public Course getById(int id){
        return courses.stream().filter(c->c.getId()==id).findFirst().orElse(null);
    }

    public  void deleteCourse(int id){
        Course courseToDelete = courses.stream().filter(c-> c.getId()==id).findFirst().orElse(null);
        if(courseToDelete != null){
            courses.remove(courseToDelete);
        }
    }
    public void save(Course course){
        boolean notExists= courses.stream().noneMatch(c->c.getId() == course.getId());
        if(notExists) {
            courses.add(course);
        }
    }
}
