package miu.edu.test.controller;

import miu.edu.test.dto.CourseDto;
import miu.edu.test.dto.StudentDto;
import miu.edu.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping
    public ResponseEntity<List<CourseDto>> Get(){

        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAll());
    }

    @PostMapping
    public ResponseEntity<CourseDto> Create(@RequestBody CourseDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDto> Delete(@PathVariable int id){
        var stu =  courseService.delete(id);
        if(stu== null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> Update(@PathVariable int id, @RequestBody CourseDto crs){
        var crsDb =  courseService.update(id, crs);
        if(crsDb== null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(crsDb);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getById(id));
    }
}
