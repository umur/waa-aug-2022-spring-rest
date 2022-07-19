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
