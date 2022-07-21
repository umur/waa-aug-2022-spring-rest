package controller;

import domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
        @Autowired
        private final CourseService courseService;

        public CourseController(CourseService courseService) {
            this.courseService = courseService;
        }

        @GetMapping
        public List<Course> findAllCourses() {
            return courseService.findAll();
        }

        @PostMapping
        public Course create(@RequestBody Course course) {
            courseService.create(course);
            return course;
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathVariable int id) {
            courseService.delete(id);
            return ResponseEntity.ok("Deleted");
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> update(@RequestBody Course course, @PathVariable int id) {
            courseService.update(course, id);
            return ResponseEntity.ok("Updated");
        }
}
