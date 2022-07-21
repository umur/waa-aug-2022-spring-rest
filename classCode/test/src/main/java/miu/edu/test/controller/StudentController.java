package miu.edu.test.controller;

import miu.edu.test.dto.CourseDto;
import miu.edu.test.dto.StudentCreateDto;
import miu.edu.test.dto.StudentDto;
import miu.edu.test.entity.Student;
import miu.edu.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> Get(){

        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
    }

    @PostMapping
    public ResponseEntity<StudentDto> Create(@RequestBody StudentCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> Delete(@PathVariable int id){
        var stu =  studentService.delete(id);
        if(stu== null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> Update(@PathVariable int id, @RequestBody StudentCreateDto stu){
        var studto =  studentService.update(id, stu);
        if(studto== null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(studto);
    }
//    List<StudentDto> getStudentsByMajor(String major);
//    List<CourseDto> getCoursesByStudentId(int studentId);
    @GetMapping("/filter-by-major")
    public ResponseEntity<List<StudentDto>> getStudentsByMajor(@RequestParam String major){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsByMajor(major));
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseDto>> getCoursesByStudentId(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getCoursesByStudentId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent(id));
    }


}
