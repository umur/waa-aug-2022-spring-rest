package com.miu.lab.repository;

import com.miu.lab.entity.Course;
import com.miu.lab.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {
    private List<Course> courses=new ArrayList<>();

    public List<Course> findAll(){
        return courses;
    }

    public void save(Course course){
        courses.add(course);
    }

    //For now get then delete it and save new one , in real db will be update real field
    public Course update(Course c) {
        Optional<Course> currentCourse=courses.stream().filter((Course s) -> s.getId()== c.getId()).findFirst();
        if(!currentCourse.isPresent())
            return  null;

        delete(currentCourse.get());

        save(c);

        return c;
    }


    public void delete(int courseId){
        Optional<Course> currentCourse=courses.stream().filter((Course s) -> s.getId()== courseId).findFirst();
        if(!currentCourse.isPresent())
            return  ;

        courses.remove(currentCourse.get());
    }
    public void delete(Course c){
        courses.remove(c);
    }
}
