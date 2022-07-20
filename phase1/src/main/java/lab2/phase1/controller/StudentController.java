package lab2.phase1.controller;

import lab2.phase1.domain.Course;
import lab2.phase1.domain.Student;
import lab2.phase1.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private final IStudentService serv;

    public StudentController(IStudentService serv)
    {
        this.serv = serv;
    }

    @PostMapping
    Boolean create(Student stu){
        return serv.create(stu);
    }

    @GetMapping
    List<Student> read(){
        return serv.read();
    }

    @PutMapping
    Boolean update(int id, Student stu){
        return serv.update(id, stu);
    }

    @DeleteMapping
    Boolean delete(int id){
        return serv.delete(id);
    }

    @GetMapping("/getCoursesByStudentId/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByStudentId(@PathVariable int studentId) {
        return serv.getCoursesByStudentId(studentId);
    }

    @GetMapping("/getStudentsByMajor/{major}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return serv.getStudentsByMajor(major);
    }
}
