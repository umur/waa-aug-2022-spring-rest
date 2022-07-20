package lab2.phase3.controller;

import lab2.phase3.domain.Course;
import lab2.phase3.domain.Student;
import lab2.phase3.dto.CourseDTO;
import lab2.phase3.dto.StudentDTO;
import lab2.phase3.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private final IStudentService serv;

    public StudentController(IStudentService serv) {
        this.serv = serv;
    }

    @PostMapping
    Boolean create(@RequestBody StudentDTO stu) {
        return serv.create(stu);
    }

    @GetMapping
    List<StudentDTO> read() {
        return serv.read();
    }

    @PutMapping("/{id}")
    Boolean update(@PathVariable int id, @RequestBody StudentDTO stu) {
        return serv.update(id, stu);
    }

    @DeleteMapping("/{id}")
    Boolean delete(@PathVariable int id) {
        return serv.delete(id);
    }

    @GetMapping("/getCoursesByStudentId/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getCoursesByStudentId(@PathVariable int studentId) {
        return serv.getCoursesByStudentId(studentId);
    }

    @GetMapping("/getStudentsByMajor/{major}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getStudentsByMajor(@PathVariable String major) {
        return serv.getStudentsByMajor(major);
    }
}
