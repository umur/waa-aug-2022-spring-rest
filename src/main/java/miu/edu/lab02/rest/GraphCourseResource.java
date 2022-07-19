package miu.edu.lab02.rest;

import miu.edu.lab02.model.Course;
import miu.edu.lab02.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphCourseResource {

    @Autowired
    CourseService service;

    @QueryMapping
    public Course todoById(@Argument Integer id) {
        return service.findOne(id);
    }
}
