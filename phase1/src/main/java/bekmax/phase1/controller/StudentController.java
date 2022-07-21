package bekmax.phase1.controller;

import bekmax.phase1.model.Course;
import bekmax.phase1.model.Student;
import bekmax.phase1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> fetchAll(@RequestParam(required = false) String major) {
        if (major != null && !major.isEmpty()){
            return studentService.getByMajor(major);
        } else{
            return studentService.fetchAll();
        }
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCourses(@PathVariable long id){
        return studentService.getCoursesByStudentId(id);
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentService.delete(id);
    }

    @PutMapping
    public void update(@PathVariable long id, @RequestBody Student student) {
        studentService.update(id, student);
    }

}
