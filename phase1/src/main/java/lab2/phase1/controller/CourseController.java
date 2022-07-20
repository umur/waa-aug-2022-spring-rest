package lab2.phase1.controller;

import lab2.phase1.domain.Course;
import lab2.phase1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    private final CourseService serv;

    @Autowired
    public CourseController(CourseService serv) {
        this.serv = serv;
    }

    @PostMapping
    Boolean create(@RequestBody Course stu) {
        return serv.create(stu);
    }

    @GetMapping
    List<Course> read() {
        return serv.read();
    }

    @PutMapping("/{id}")
    Boolean update(@PathVariable int id, @RequestBody Course stu) {
        return serv.update(id, stu);
    }

    @DeleteMapping("/{id}")
    Boolean delete(@PathVariable int id) {
        return serv.delete(id);
    }
}
