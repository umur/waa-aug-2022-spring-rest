package miu.edu.lab02.rest;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.model.Student;
import miu.edu.lab02.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/students")
public class StudentResource {

    private final StudentServiceImpl studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student save(@RequestBody Student body) {
        return studentService.save(body);
    }

    @PutMapping("{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student body) {
        return studentService.update(id, body);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentService.findOne(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }

    @GetMapping("filter-by-major/{major}")
    public void filterByMajor(@PathVariable String major) {
        studentService.getStudentsByMajor(major);
    }

    @GetMapping("courses/{id}")
    public void filterByMajor(@PathVariable Integer id) {
        studentService.getCoursesByStudentId(id);
    }
}
