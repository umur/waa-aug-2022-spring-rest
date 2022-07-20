package lab2.phase4.controller;

import lab2.phase4.domain.Course;
import lab2.phase4.dto.CourseDTO;
import lab2.phase4.service.CourseService;
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
    Boolean create(@RequestBody CourseDTO stu) {
        return serv.create(stu);
    }

    @GetMapping
    List<CourseDTO> read() {
        return serv.read();
    }

    @PutMapping("/{id}")
    Boolean update(@PathVariable int id, @RequestBody CourseDTO stu) {
        return serv.update(id, stu);
    }

    @DeleteMapping("/{id}")
    Boolean delete(@PathVariable int id) {
        return serv.delete(id);
    }
}
