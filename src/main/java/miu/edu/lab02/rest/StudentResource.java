package miu.edu.lab02.rest;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.dto.CourseDTO;
import miu.edu.lab02.dto.StudentDTO;
import miu.edu.lab02.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/students")
public class StudentResource {

    private final StudentServiceImpl studentService;

    @GetMapping // All
    public List<StudentDTO> getStudents() {
        return studentService.findAll();
    }

    @PostMapping  // Create
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO save(@RequestBody StudentDTO body) {
        return studentService.save(body);
    }

    @PutMapping("{id}") // Update
    public StudentDTO update(@PathVariable Integer id, @RequestBody StudentDTO body) {
        return studentService.update(id, body);
    }

    @GetMapping("{id}") // Retrieve
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer id) {
        return studentService.findOne(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("{id}") // Delete
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }


    @GetMapping("by-major") // filter students by major
    public List<StudentDTO> filterByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("courses/{id}") // list courses of student
    public List<CourseDTO> filterByMajor(@PathVariable Integer id) {
        return studentService.getCoursesByStudentId(id);
    }

    @PostMapping("courses/{id}/{code}") // add course to student
    public ResponseEntity<StudentDTO> addCourse(@PathVariable Integer id, @PathVariable String code) {
        return Optional.ofNullable(studentService.addCourse(id, code))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("courses/{id}/{code}") // remove course from student
    public ResponseEntity<StudentDTO> removeCourse(@PathVariable Integer id, @PathVariable String code) {
        return Optional.ofNullable(studentService.removeCourse(id, code))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
