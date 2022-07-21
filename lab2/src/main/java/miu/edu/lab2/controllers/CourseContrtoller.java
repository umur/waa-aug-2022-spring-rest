package miu.edu.lab2.controllers;

import miu.edu.lab2.dtos.CourseDto;
import miu.edu.lab2.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseContrtoller {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDto> getAllCourses(){
        return courseService.getAll();
    }

    @PostMapping
    public ResponseEntity saveCourse(@RequestBody CourseDto courseDto){
        courseService.save(courseDto);
        return new ResponseEntity("Course created successfully",HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity deleteCourse(@RequestBody CourseDto courseDto){
        courseService.delete(courseDto);
        return new ResponseEntity("Course deleted successfully",HttpStatus.OK);
    }
}
