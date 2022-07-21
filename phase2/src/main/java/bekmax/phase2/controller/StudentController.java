package bekmax.phase2.controller;

import bekmax.phase2.dto.CourseDto;
import bekmax.phase2.dto.StudentDto;
import bekmax.phase2.service.StudentService;
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
    public List<StudentDto> fetchAll(@RequestParam(required = false) String major) {
        if (major != null && !major.isEmpty()){
            return studentService.getByMajor(major);
        } else{
            return studentService.fetchAll();
        }
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCourses(@PathVariable long id){
        return studentService.getCoursesByStudentId(id);
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentService.delete(id);
    }

    @PutMapping
    public void update(@PathVariable long id, @RequestBody StudentDto studentDto) {
        studentService.update(id, studentDto);
    }

}
